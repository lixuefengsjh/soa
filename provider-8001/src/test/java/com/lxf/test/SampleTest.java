package com.lxf.test;

import com.lxf.entity.OptionFunding;
import com.lxf.repository.MonthProfitRepository;
import com.lxf.service.OptionFundingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private MonthProfitRepository monthProfitRepository;

    @Test
    public void testGenerator(){
        List<Long> ids= Arrays.asList(3L);
         int i=monthProfitRepository.deleteByIdIn(ids);
        System.out.println(i);
    }
}

