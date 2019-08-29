package person.pulei.myshopplus.business.service;

import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import person.pulei.myshopplus.provider.api.UmsAdminService;
import person.pulei.myshopplus.provider.domain.UmsAdmin;

import java.lang.annotation.ElementType;
import java.util.List;

/**
 * UserDetailsServiceImpl
 *
 * @author LeeSa1
 * @date 2019/8/28 14:37
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(grantedAuthority);

        UmsAdmin umsAdmin = umsAdminService.get(s);
        if (umsAdmin != null) {
            return new User(umsAdmin.getUsername(), umsAdmin.getPassword(), grantedAuthorities);
        } else {
            return null;
        }
    }
}
