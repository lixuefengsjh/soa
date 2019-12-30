package com.lxf.controller;

import com.lxf.common.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/optionFunding")
@Api(tags = {"分红详情记录"})
public class OptionFundingController {

    @Autowired
    private ThreadPoolTaskExecutor defaultThreadPool;
    /**
     * 获取某一股权上个月累计收益
     *
     * @param stockCode 股权代码
     * @return
     */
    @ApiOperation(value = "获取某一股权上个月累计收益")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockCode", value = "股权代码", required = true, dataType = "String")
    })
    @GetMapping("/bonus/lastmonth")
    public HttpResult getLastMonthTotalBonus(String stockCode) {
        return HttpResult.success();
    }

    /**
     * 测试多线程功能
     * @return
     */
    @ApiOperation(value = "测试多线程工作")
    @GetMapping("/bonus/test")
    public HttpResult test() {
        int[] ins=new int[6];
        for(int i:ins){
            int count=0;
            i=count;
            count++;
        }
        for(int i=0;i<ins.length;i++){
            AtomicInteger cou=new AtomicInteger(0);
            defaultThreadPool.execute(()->{
                cou.addAndGet(1);
                ins[cou.get()]+=2;
            });
        }

        return HttpResult.success(ins);
    }

}
