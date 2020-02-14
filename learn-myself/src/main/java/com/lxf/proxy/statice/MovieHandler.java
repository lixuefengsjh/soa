package com.lxf.proxy.statice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MovieHandler implements InvocationHandler {
    private Movie  movie;
    public MovieHandler(Movie  movie){
        this.movie=movie;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       if(method.getName().equals("say")){
           System.out.println("利用动态代理的方式测试say()");
           System.out.println(proxy.getClass().toString());
            method.invoke(movie,args);
       }else{
           method.invoke(movie,args);
       }
        return null;
    }
}
