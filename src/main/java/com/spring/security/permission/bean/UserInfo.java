package com.spring.security.permission.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author MouseSun
 * @Date 2020/7/10 17:11
 * @Address 杭州电子科技大学
 */
@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue
    private long uid; //主键

    private String username; //用户名

    private String password; //密码

    @Enumerated(EnumType.STRING) //映射枚举类型
    private Role role;

    public enum Role{
        admin,normal
    }
}
