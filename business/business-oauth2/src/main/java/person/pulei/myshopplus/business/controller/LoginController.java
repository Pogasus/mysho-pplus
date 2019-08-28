package person.pulei.myshopplus.business.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import person.pulei.myshopplus.business.dto.LoginParma;
import person.pulei.myshopplus.commons.dto.ResponseResult;

/**
 * LoginController
 *
 * @author LeeSa1
 * @date 2019/8/28 19:30
 */

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class LoginController {

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody LoginParma loginParma) {
        System.out.println(loginParma.getUsername());
        return new ResponseResult(HttpStatus.OK.value(), HttpStatus.OK.toString(), null);
    }

}
