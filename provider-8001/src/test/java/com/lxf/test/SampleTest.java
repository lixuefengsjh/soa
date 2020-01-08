package com.lxf.test;

import com.lxf.entity.OptionFunding;
import com.lxf.entity.Role;
import com.lxf.service.OptionFundingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private OptionFundingService optionFundingService;

    @Test
    public void testGenerator(){
        List<OptionFunding> lists=optionFundingService.findOptionFundingByOptionTime();
        System.out.println(lists);
    }

    @Test
    public void test1(){
        Role role =null;
       // Optional<Role> = new Optional(role);
    }

}

