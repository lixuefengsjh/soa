package com.lxf.web;



import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lxf
 * @date 2020/1/15 17:53
 * @modified
 * @description 过滤器测试
 */
@Component
public class MyFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化成功---------------");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入---------------");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开入---------------");
    }

    public void destroy() {
        System.out.println("过滤器销毁-------------------------");
    }
}