package com.spring.security.permission.init;

import com.spring.security.permission.bean.UserInfo;
import com.spring.security.permission.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static com.spring.security.permission.bean.UserInfo.Role.admin;

/**
 * @Author MouseSun
 * @Date 2020/7/10 17:32
 * @Address 杭州电子科技大学
 */
@Service
public class DataInit {

    /*@Autowired
    private UserInfoRepository userInfoRepository;

    @PostConstruct //初始化构造器的时候执行
    public void dataInit(){

        UserInfo userInfo =  new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setPassword("123");
        userInfo.setRole(admin);
        userInfoRepository.save(userInfo);

        userInfo = new UserInfo();
        userInfo.setUsername("user");
        userInfo.setPassword("456");
        userInfo.setRole(UserInfo.Role.normal);
        userInfoRepository.save(userInfo);


    }*/
}
