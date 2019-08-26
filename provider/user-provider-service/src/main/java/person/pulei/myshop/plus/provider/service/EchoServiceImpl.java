package person.pulei.myshop.plus.provider.service;

import org.apache.dubbo.config.annotation.Service;
import person.pulei.myshop.plus.provider.service.api.EchoService;

@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String string) {
        return "Echo Hello Dubbo " + string;
    }
}