package person.pulei.myshopplus.business.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import person.pulei.myshopplus.provider.api.EchoService;

/**
 * EchoController
 *
 * @author LeeSa1
 * @date 2019/8/28 12:38
 */
@RestController
public class EchoController {

    @Reference(version = "1.0.0")
    private EchoService echoService;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return echoService.echo(string);
    }

}
