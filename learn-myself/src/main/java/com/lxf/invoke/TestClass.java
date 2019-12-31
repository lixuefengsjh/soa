package com.lxf.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("com.lxf.invoke.Example");
        System.out.println("下面获取到类的对象----");
        System.out.println(clazz);
        /**
         * 反射获取的clazz是对类的描述。或者分解。根据clazz可以获取到类的所有信息
         */


        //1.获取构造方法
        System.out.println("下面获取到类的构造方法----");
        Constructor[] c = clazz.getConstructors();
        for (Constructor cc : c) {
            System.out.println(cc);
        }


        //2.获取指定参数的构造方法
        Constructor one = clazz.getConstructor(String.class);
        System.out.println("获取指定参数的构造方法----");
        System.out.println(one);

        System.out.println("根据构造函数生成实例对象----");
        Example example = (Example) one.newInstance("instance");
        System.out.println("使用我生成的实体对象----" + example.getName());


        //3.获取私有的构造方法
        Constructor two = clazz.getDeclaredConstructor(int.class);
        System.out.println("获取私有的构造方法----");
        System.out.println(two);
        two.setAccessible(true);
        two.newInstance(80);
        System.out.println("使用我生成的实体对象----" + example.getAge());

        //4.获取public属性
        Method method=clazz.getMethod("test2",int.class);
        Object i=method.invoke(example,6);
        System.out.println("通过反射运行的方法----"+i);
        //5.获取private属性
        Method method1=clazz.getDeclaredMethod("test1",int.class);
        method1.setAccessible(true);
        Object i1=method1.invoke(example,600);
        System.out.println("通过反射运行的方法----"+i1);
        //6.获取public方法

        //7.获取private方法
    }
}
