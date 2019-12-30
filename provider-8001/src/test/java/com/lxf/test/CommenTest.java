package com.lxf.test;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommenTest {
    @Test
    public void runTest() {

    }

    @Test
    public void runTest1() {
        int  toade=LocalDate.now().minusMonths(1).lengthOfMonth();
        System.out.println(toade);
    }
}
