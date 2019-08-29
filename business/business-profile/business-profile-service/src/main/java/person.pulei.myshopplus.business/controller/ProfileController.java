package person.pulei.myshopplus.business.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.pulei.myshopplus.commons.dto.ResponseResult;
import person.pulei.myshopplus.provider.api.UmsAdminService;
import person.pulei.myshopplus.provider.domain.UmsAdmin;

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

}
