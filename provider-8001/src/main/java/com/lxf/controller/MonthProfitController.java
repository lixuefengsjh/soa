package com.lxf.controller;

import com.lxf.common.HttpResult;
import com.lxf.entity.MonthProfit;
import com.lxf.service.MonthProfitService;
import com.lxf.util.CommonUtil;
import com.lxf.vo.MonthProfitVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
/**
 * @author Administrator
 */
@RestController
@Api(tags = {"销售记录"})
public class MonthProfitController {
    @Autowired
    private MonthProfitService monthProfitService;

    /**
     *查询销售额
     * @param stockCode  股权代码
     * @return
     */
    @ApiOperation(value = "查询销售额")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockCode", value = "股权代码", required = true, dataType = "String")
    })
    @GetMapping
    public HttpResult<List<MonthProfitVo>> findAllByStockCode(String stockCode) {
        List<MonthProfit> monthProfits = monthProfitService.findAllByStockCode(stockCode);
        if (monthProfits.size() > 0) {
            List<MonthProfitVo> monthProfitVos = CommonUtil.copyList(monthProfits,MonthProfitVo.class);
            return HttpResult.success(monthProfitVos);
        }

        return HttpResult.error("");
    }

    /**
     * 保存月度销售额
     * @return
     */
    @ApiOperation(value = "保存销售额")
    @PostMapping
    public HttpResult saveMonthProfit(@RequestBody MonthProfitVo monthProfitVo) {
        MonthProfit monthProfit=new MonthProfit();
        BeanUtils.copyProperties(monthProfitVo,monthProfit);
        monthProfit.setRecordTime(LocalDate.parse(monthProfitVo.getRecordTime()+"-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(monthProfit);
        monthProfitService.saveMonthProfit(monthProfit);
        return  HttpResult.success();
    }
    /**
     *批量删除
     * @param id 主键
     * @return
     */
    @ApiOperation(value = "删除销售额")
    @PostMapping("/delete")
    public HttpResult deleteMonthProfitInBatch(@RequestBody List<Long> id) {
        monthProfitService.deleteMonthProfitById(id);
        return HttpResult.success();
    }

    /**
     * 修改销售额
     * @param stockCode 股权代码
     * @param salesAmount 销售额
     * @param percentage 百分数
     * @param recordTime 月度
     * @return
     */
    @ApiOperation(value = "修改销售额")
    @PostMapping("/update")
    public HttpResult updateMonthProfit(@RequestBody MonthProfitVo monthProfitVo) {
        MonthProfit monthProfit  = new MonthProfit();
        BeanUtils.copyProperties(monthProfitVo,monthProfit);
        monthProfit.setRecordTime(LocalDate.parse(monthProfitVo.getRecordTime(),DateTimeFormatter.ofPattern("yyyy-MM")));
        monthProfitService.updateMonthProfit(monthProfit);
        return HttpResult.success();
    }
}
