package com.lxf.proxy.statice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class StaticProxy implements  Movie {
    private Movie movie;
    public void play() {
        System.out.println("你必须先充值才能观看");
        movie.play();
    }

    public void say() {

    }

    public StaticProxy(Movie movie){
        this.movie=movie;
    }
}
