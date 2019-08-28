package person.pulei.myshopplus.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * BusinessOauth2Tests
 *
 * @author LeeSa1
 * @date 2019/8/28 14:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessOauth2Tests {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void TestPassword() {
        System.out.println(passwordEncoder.encode("123456"));
    }

}
