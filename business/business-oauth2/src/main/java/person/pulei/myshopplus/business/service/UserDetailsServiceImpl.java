package person.pulei.myshopplus.business.service;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * UserDetailsServiceImpl
 *
 * @author LeeSa1
 * @date 2019/8/28 14:37
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "$2a$10$ZvBFdeC0uKbiC3WEakxCauDEgwPOm88CyD8crUHeaOFqdIiIlG/l2";

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        return new User(USER_NAME, PASSWORD, grantedAuthorities);
    }
}
