package com.lxf.controller.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxf
 * @date 2020/1/7 16:31
 * @modified
 * @description 测试
 */
@RestController
public class UserRegisterController {
    @Autowired
    private UserRegisterService  userRegisterService;
    @GetMapping("/test1")
    public String  say(User user){
         user=new User(1,"lxf","11222222","121212@qq.com");
        return  userRegisterService.success(user);
    }
}
