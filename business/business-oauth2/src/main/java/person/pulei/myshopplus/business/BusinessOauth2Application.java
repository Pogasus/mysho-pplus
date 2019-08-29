package person.pulei.myshopplus.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * BusinessOauth2Application
 *
 * @author LeeSa1
 * @date 2019/8/28 14:17
 */

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class BusinessOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(BusinessOauth2Application.class, args);
    }

}
