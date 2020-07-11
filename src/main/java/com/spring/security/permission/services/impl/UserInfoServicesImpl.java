package com.spring.security.permission.services.impl;

import com.spring.security.permission.bean.UserInfo;
import com.spring.security.permission.repository.UserInfoRepository;
import com.spring.security.permission.services.UserInfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author MouseSun
 * @Date 2020/7/10 17:23
 * @Address 杭州电子科技大学
 */
@Service
public class UserInfoServicesImpl implements UserInfoServices {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }
}
