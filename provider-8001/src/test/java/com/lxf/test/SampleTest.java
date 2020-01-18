package com.lxf.test;

import com.lxf.entity.OptionFunding;
import com.lxf.service.OptionFundingService;
import com.lxf.service.Queue_provider;
import com.lxf.util.RedisUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testGenerator(){
        redisUtil.set("lxf3434","ces121212",10);

    }

//    @Autowired
//    private WebApplicationContext wac;
//    private MockMvc mvc;
//    @Before
//    public void setup(){
//        mvc= MockMvcBuilders.webAppContextSetup(wac).build();
//    }
//    @Test
//    public void testq() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/user").contentType(MediaType.APPLICATION_JSON).param("user","pp"))
//
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
}

