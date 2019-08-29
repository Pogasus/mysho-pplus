package person.pulei.myshopplus.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import person.pulei.myshopplus.configure.FeignRequestConfiguration;

/**
 * @author puxin
 */
@FeignClient(value = "business-profile", path = "profile", configuration = FeignRequestConfiguration.class)
public interface ProfileFeign {

    @GetMapping("info/{username}")
    String info(@PathVariable String username);

}
