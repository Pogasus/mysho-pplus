package person.pulei.myshopplus.business.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.pulei.myshopplus.business.dto.ProfileParam;
import person.pulei.myshopplus.business.feign.ProfileFeign;
import person.pulei.myshopplus.commons.dto.ResponseResult;
import person.pulei.myshopplus.provider.api.UmsAdminService;
import person.pulei.myshopplus.provider.domain.UmsAdmin;
import sun.java2d.cmm.Profile;

import javax.annotation.Resource;

/**
 * ProfileController
 * 个人信息管理
 * @author LeeSa1
 * @date 2019/8/29 14:40
 */

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;


    @GetMapping("/info/{username}")
    public ResponseResult<UmsAdmin> info(@PathVariable String username) {
        UmsAdmin umsAdmin = umsAdminService.get(username);
        if (umsAdmin != null) {
            return new ResponseResult<UmsAdmin>(ResponseResult.CodeStatus.OK, "获取用户信息", umsAdmin);
        }
        return new ResponseResult<UmsAdmin>(ResponseResult.CodeStatus.FAIL, "获取用户信息失败", null);
    }

    @PostMapping("update")
    public ResponseResult<Void> update(@RequestBody ProfileParam profileParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(profileParam, umsAdmin);
        int result = umsAdminService.update(umsAdmin);
        if (result > 0) {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "更新用户信息成功");
        } else {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "更新用户信息失败");
        }
    }


}
