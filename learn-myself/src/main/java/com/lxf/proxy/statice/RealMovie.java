package com.lxf.proxy.statice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RealMovie implements Movie {
    private String name;

    public void play() {
        System.out.println("正在播放的电影名字叫:   " + name);
    }
    public void say() {
        System.out.println("电影快要开始了");
    }

    public RealMovie(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {
       //InputStream s

        Movie aFanDa = new RealMovie("阿凡达");
        /**
         * 一下代码展示的是静态代理
         */
        Movie proxy =new StaticProxy(aFanDa);
        proxy.play();
        /**
         * 下面将使用动态代理进行代码功能扩充
         */
        Movie dynamicProxy= (Movie) Proxy.newProxyInstance(aFanDa.getClass().getClassLoader(),aFanDa.getClass().getInterfaces(),new MovieHandler(aFanDa));
        dynamicProxy.say();
        dynamicProxy.play();
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.class.path"));

    }
}
