package person.pulei.myshopplus.configure;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import person.pulei.myshopplus.interceptor.FeignRequestInterceptor;

/**
 * FeignRequestConfiguration
 *
 * @author LeeSa1
 * @date 2019/8/29 15:40
 */

@Configuration
public class FeignRequestConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }

}
