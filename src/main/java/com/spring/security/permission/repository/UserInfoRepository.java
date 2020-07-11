package com.spring.security.permission.repository;

import com.spring.security.permission.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @Author MouseSun
 * @Date 2020/7/10 17:21
 * @Address 杭州电子科技大学
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
    public UserInfo findByUsername(String username);
}
