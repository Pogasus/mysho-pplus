package person.pulei.myshopplus.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * BusinessProfileApplication
 *
 * @author LeeSa1
 * @date 2019/8/29 14:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BusinessProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessProfileApplication.class, args);
    }

}
