package person.pulei.myshopplus.business.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.pulei.myshopplus.commons.dto.ResponseResult;
import person.pulei.myshopplus.provider.api.UmsAdminService;
import person.pulei.myshopplus.provider.domain.UmsAdmin;

/**
 * RegController
 *
 * @author LeeSa1
 * @date 2019/8/26 16:27
 */
@RestController
@RequestMapping("reg")
public class RegController {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    @PostMapping("")
    public ResponseResult<UmsAdmin> reg(@RequestBody UmsAdmin umsAdmin) {
        String validateReg = validateReg(umsAdmin);
        if (validateReg.equals("ok")) {
            int result = umsAdminService.insert(umsAdmin);
            if (result != 0) {
                UmsAdmin admin = umsAdminService.get(umsAdmin.getUsername());
                return new  ResponseResult<UmsAdmin>(HttpStatus.OK.value(),"用户注册成功",admin);
            }
        }
        return new ResponseResult<UmsAdmin>(HttpStatus.NOT_ACCEPTABLE.value(),validateReg != null ? validateReg : "新用户注册失败");
    }

    /**
     * 验证注册信息
     * @param umsAdmin {@link UmsAdmin}
     * @return 错误信息
     */
    private String validateReg(UmsAdmin umsAdmin) {
        UmsAdmin admin = umsAdminService.get(umsAdmin.getUsername());
        if (admin != null) {
            return "用户名已存在，请重新输入";
        }
        return "ok";
    }

}