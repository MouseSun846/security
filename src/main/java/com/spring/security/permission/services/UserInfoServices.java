package com.spring.security.permission.services;

import com.spring.security.permission.bean.UserInfo;

/**
 * @Description TODO
 * @Author MouseSun
 * @Date 2020/7/10 17:23
 * @Address 杭州电子科技大学
 */
public interface UserInfoServices {
    public UserInfo findByUsername(String username);
}
