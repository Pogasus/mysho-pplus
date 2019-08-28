package person.pulei.myshopplus.provider.service;

import org.apache.dubbo.config.annotation.Service;
import person.pulei.myshopplus.provider.api.EchoService;

/**
 * EchoServiceImpl
 *
 * @author LeeSa1
 * @date 2019/8/28 10:23
 */

@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String string) {
        return string;
    }

}
