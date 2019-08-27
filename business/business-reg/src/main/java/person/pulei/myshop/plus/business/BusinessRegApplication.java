package person.pulei.myshop.plus.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * BusinessRegApplication
 *
 * @author LeeSa1
 * @date 2019/8/26 14:14
 */

@SpringBootApplication
@EnableDiscoveryClient
public class BusinessRegApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessRegApplication.class, args);
    }

}
