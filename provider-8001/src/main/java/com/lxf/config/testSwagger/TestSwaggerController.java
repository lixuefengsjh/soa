package com.lxf.config.testSwagger;

import com.lxf.vo.TestSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"测试swagger的基本功能"})
public class TestSwaggerController {
  @PostMapping("/testSwagger")

    public void testsWagger(  @RequestBody   TestSwagger testSwagger){
      System.out.println("7777777");

  }
}
