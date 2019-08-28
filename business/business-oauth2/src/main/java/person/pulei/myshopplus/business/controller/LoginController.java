package person.pulei.myshopplus.business.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseResult login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println(username);
        return new ResponseResult(HttpStatus.OK.value(), HttpStatus.OK.toString(), username);
    }

}
