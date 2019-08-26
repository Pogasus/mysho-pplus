package person.pulei.myshop.plus.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * UmsAdminProviderApplication
 *
 * @author LeeSa1
 * @date 2019/8/23 16:53
 */

@SpringBootApplication
@MapperScan("person.pulei.myshop.plus.provider.mapper")
public class UmsAdminProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmsAdminProviderApplication.class, args);
    }
}
