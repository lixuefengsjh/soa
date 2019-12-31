package com.lxf.invoke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Example {
    private String name;
    private String desc;
    public int age;

    public Example(String name) {
        this.name = name;
    }

    private Example(int age) {
        System.out.println("这是一个私有的构造函数，你是不能使用的");
        this.age = age;
    }

    private int test1(int i) {
        System.out.println("test1------的方法");
        return i;
    }

    public int test2(int i) {
        System.out.println("test2-------的方法");
        return i;
    }

}
