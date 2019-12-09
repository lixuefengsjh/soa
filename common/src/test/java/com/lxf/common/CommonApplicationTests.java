package com.lxf.common;

import com.lxf.common.entity.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommonApplicationTests {

    @Test
    void contextLoads() {
        Dept dept=new Dept();
        dept.getDeptno();


    }

}
