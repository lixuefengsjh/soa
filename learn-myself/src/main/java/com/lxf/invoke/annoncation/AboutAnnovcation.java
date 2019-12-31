package com.lxf.invoke.annoncation;

import java.lang.reflect.Field;

@TypeAnnocation(id = 1, name = "this is class,AboutAnnovcation")
public class AboutAnnovcation {
    @FieldAnnocation(Filed = "this is Filed,desc")
    public String desc="hello";

    public int age;
    public AboutAnnovcation() {

    }
    public AboutAnnovcation(String desc) {
        this.desc = desc;
    }

    @MethodAnnocation(method = "this is method ,say")
    public void say() {

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        //我想利用FieldAnnocation.强制设置desc 不能未"hello"
        Class clazz = Class.forName("com.lxf.invoke.annoncation.AboutAnnovcation");
        AboutAnnovcation aboutAnnovcation = (AboutAnnovcation) clazz.newInstance();
        Field[] Fields = clazz.getFields();
        for (Field field : Fields) {
            boolean flag = field.isAnnotationPresent(FieldAnnocation.class);
            if (flag) {
                if (field.get(aboutAnnovcation).equals("hello")) {
                    throw new RuntimeException("不能设置为：hello");
                }
            }
        }

    }
}
