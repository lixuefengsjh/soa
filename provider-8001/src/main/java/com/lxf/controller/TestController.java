package com.lxf.controller;

import com.lxf.entity.TestClass;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authhor: lxf
 * @create: 2020-02-06 17:56
 * @description: ces
 */
@RestController
@RequestMapping("/test")
@Api(tags = {"ces"})
public class TestController {
    @PostMapping
    public void save(@RequestBody TestClass t ,String real){
        System.out.println(t);
        System.out.println(real);
    };
}
