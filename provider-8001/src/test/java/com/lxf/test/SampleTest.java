package com.lxf.test;

import com.lxf.dao.DeptMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private DeptMapper deptMapper;



    @Test
    public void testSelect() {
        System.out.println(deptMapper.selectById(1));
    }

}