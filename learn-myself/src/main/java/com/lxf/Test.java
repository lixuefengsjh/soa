package com.lxf;

import java.io.*;

/**
 * @authhor: lxf
 * @create: 2020-02-01 09:27
 * @description: 测试 继承和实现
 */
public class Test {
    public static void main(String[] args) throws IOException {
        InputStream s=new FileInputStream("D:\\work\\lxf.txt");
        OutputStream out =new FileOutputStream("D:\\work\\lxf1.txt");
        Byte[] b=new Byte[2];
        int a=s.read();
        while (a>-1){
            out.write(a);
            a=s.read();
        }
    }
}
