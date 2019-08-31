package person.pulei.myshopplus.business.controller;

import com.google.common.collect.Maps;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import person.pulei.myshopplus.business.dto.LoginInfo;
import person.pulei.myshopplus.business.dto.LoginParma;
import person.pulei.myshopplus.business.feign.ProfileFeign;
import person.pulei.myshopplus.commons.dto.ResponseResult;
import person.pulei.myshopplus.commons.utils.MapperUtils;
import person.pulei.myshopplus.commons.utils.OkHttpClientUtil;
import person.pulei.myshopplus.provider.domain.UmsAdmin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;

/**
 * LoginController
 *
 * @author LeeSa1
 * @date 2019/8/28 19:30
 */

@RestController
public class LoginController {

    private static final String URL_OAUTH2_TOKEN = "http://localhost:9001/oauth/token";

    @Value("${business.oauth2.grant_type}")
    private String oauth2GrantType;

    @Value("${business.oauth2.client_id}")
    private String oauth2ClientId;

    @Value("${business.oauth2.client_secret}")
    private String oauth2ClientSecret;

    @Resource(name = "userDetailsService")
    private UserDetailsService userDetailsService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private TokenStore tokenStore;

    @Resource
    private ProfileFeign profileFeign;

    @PostMapping("/user/login")
    public ResponseResult<Map<String,Object>> login(@RequestBody LoginParma loginParma) {

        //验证用户名密码是否正确
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParma.getUsername());
        if (userDetails == null || !passwordEncoder.matches(loginParma.getPassword(),userDetails.getPassword())) {
            return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.FAIL, "账户或用户名错误",null);
        }

        // 通过 HTTP 客户端请求登录接口
        Map<String, Object> result = Maps.newHashMap();
        System.out.println(loginParma.getUsername());
        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParma.getUsername());
        params.put("password", loginParma.getPassword());
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);

        Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH2_TOKEN, params);
        try {
            Map<String, Object> json2map = MapperUtils.json2map(Objects.requireNonNull(response.body()).string());
            String access_token = String.valueOf(json2map.get("access_token"));
            result.put("token", access_token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.OK, "登录成功", result);
    }

    @GetMapping("/user/info")
    public ResponseResult<LoginInfo> info() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String jsonInfo = profileFeign.info(authentication.getName());
        LoginInfo loginInfo = new LoginInfo();
        try {
            UmsAdmin umsAdmin = MapperUtils.json2pojoByTree(jsonInfo, "data", UmsAdmin.class);
            loginInfo.setName(umsAdmin.getUsername());
            loginInfo.setAvatar(umsAdmin.getIcon());
            loginInfo.setNickName(umsAdmin.getNickName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<LoginInfo>(ResponseResult.CodeStatus.OK, "获取用户信息", loginInfo);
    }

    @PostMapping("/user/logout")
    public ResponseResult logout(HttpServletRequest request) {
        String access_token = request.getParameter("access_token");
        OAuth2AccessToken token = tokenStore.readAccessToken(access_token);
        tokenStore.removeAccessToken(token);
        return new ResponseResult(ResponseResult.CodeStatus.OK, "用户注销", null);
    }

}
