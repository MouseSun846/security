package com.spring.security.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MouseSun
 * @Date 2020/7/9 20:35
 * @Address 杭州电子科技大学
 */
@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/mouse")
    @PreAuthorize("hasAnyRole('admin')")
    public String helloMouse(){
        return "mouse";
    }

    @GetMapping("/sun")
    @PreAuthorize("hasAnyRole('normal')")
    public String helloSun(){
        return "sun";
    }
}
