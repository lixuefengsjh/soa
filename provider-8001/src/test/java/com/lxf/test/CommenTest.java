package com.lxf.test;

import org.junit.Test;

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
        List<Integer> lists = new ArrayList<Integer>();
        Map<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            maps.put(i + "--" + i, i);
        }
 for(Map.Entry s:maps.entrySet()){
     System.out.println(s.getKey()+"$$"+s.getValue());
 }


        ;
    }
}
