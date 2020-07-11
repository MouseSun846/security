package com.spring.security.config;

import com.spring.security.permission.bean.UserInfo;
import com.spring.security.permission.services.UserInfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MouseSun
 * @Date 2020/7/10 17:25
 * @Address 杭州电子科技大学
 */
@Component
public class CustomUserServices implements UserDetailsService {
    /**
     * 1 通过username获取到userinfo
     * 2 通过User(UserDetails)返回UserDetails
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */

    @Autowired
    private UserInfoServices userInfoServices;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoServices.findByUsername(username);
        if(userInfo == null){
            throw new UsernameNotFoundException("not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+userInfo.getRole().name()));
        User user = new User(userInfo.getUsername(),passwordEncoder.encode(userInfo.getPassword()),authorities);
        return user;
    }
}
