package person.pulei.myshop.plus.business.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.pulei.myshop.plus.provider.service.api.EchoService;

/**
 * EchoController
 *
 * @author LeeSa1
 * @date 2019/8/26 14:15
 */

@RestController
@RequestMapping("echo")
public class EchoController {

    @Reference(version = "1.0.0")
    private EchoService echoService;

    @GetMapping("{string}")
    public String encho(@PathVariable("string") String string) {
        return string;
    }

}
