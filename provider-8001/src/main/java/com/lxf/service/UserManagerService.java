//package com.lxf.service;
//
//import com.lxf.entity.User;
//import com.lxf.repository.UserManagerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * @author lxf
// */
//@Service("userDetailsService")
//public class UserManagerService implements UserDetailsService {
//    @Autowired
//    private UserManagerRepository userManagerRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userManagerRepository.findByLogin(s);
//        if (user == null) {
//            throw new UsernameNotFoundException("User " + s + " is not  find!");
//        }
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        //根据用户名获取
//        List<Map<String, String>> lists = userManagerRepository.findUserRole(s);
//        grantedAuthorities= lists.stream().map(e -> {
//            return  new SimpleGrantedAuthority("ROLE_"+e.get("role_name")) ;
//        }).collect(Collectors.toSet());
//        // AuthorityUtil工具类处理权限
//        //这里的user可以采用宁外一个钩爪函数，主要是判断用户是否过期等相关信息
//        return new org.springframework.security.core.userdetails.User(s, new BCryptPasswordEncoder().encode(user.getPassword())
//              , grantedAuthorities);
//    }
//}
