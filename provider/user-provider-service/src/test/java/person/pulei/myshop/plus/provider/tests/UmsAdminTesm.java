package person.pulei.myshop.plus.provider.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import person.pulei.myshop.plus.provider.mapper.UmsAdminMapper;
import person.pulei.myshop.plus.provider.service.domain.UmsAdmin;

import java.util.Date;

/**
 * UmsAdminTesm
 *
 * @author LeeSa1
 * @date 2019/8/26 15:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UmsAdminTesm {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testInsert() {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername("Lusifer");
        umsAdmin.setPassword(passwordEncoder.encode("123456"));
        umsAdmin.setIcon("");
        umsAdmin.setEmail("");
        umsAdmin.setNickName("");
        umsAdmin.setNote("");
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());
        umsAdmin.setStatus(0);

        int insert = umsAdminMapper.insert(umsAdmin);
        Assert.assertEquals(insert, 1);

    }

}
