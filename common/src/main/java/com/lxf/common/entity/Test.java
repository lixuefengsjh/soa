package com.lxf.common.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test {
    public static void main(String[] args) {
        BigDecimal a=new BigDecimal(80.632333333333);
        System.out.println(a.setScale(5, RoundingMode.DOWN));
    }
}
