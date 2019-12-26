package com.lxf.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author lxf
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthProfitVo {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("股权代码")
    private String stockCode;

    @ApiModelProperty("销售额")
    private BigDecimal salesAmount;

    @ApiModelProperty("分红比例")
    private Double percentage;

    @ApiModelProperty("月度")
    private String recordTime;
}
