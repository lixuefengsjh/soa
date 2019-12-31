package com.lxf.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.DelegatingFilterProxy;

//@RestController
//public class AboutTokenController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    FilterChainProxy
//    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
//    public Token authorize(@RequestParam String username, @RequestParam String password) {
//        // 1 创建UsernamePasswordAuthenticationToken
//        UsernamePasswordAuthenticationToken token
//                = new UsernamePasswordAuthenticationToken(username, password);
//        // 2 认证
//        Authentication authentication = this.authenticationManager.authenticate(token);
//        // 3 保存认证信息
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        // 4 加载UserDetails
//        UserDetails details = this.userDetailsService.loadUserByUsername(username);
//        // 5 生成自定义token
//        return tokenProvider.createToken(details);
//    }
//}
