package person.pulei.myshop.plus.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * UmsAdminProviderApplication
 *
 * @author LeeSa1
 * @date 2019/8/23 16:53
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("person.pulei.myshop.plus.provider.mapper")
public class UmsAdminProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmsAdminProviderApplication.class, args);
    }
}
