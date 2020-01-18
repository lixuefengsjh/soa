package com.lxf.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel
@Getter
@Setter
public class TestSwagger {
    @ApiModelProperty(value = "身高")
    private BigDecimal height;

    @ApiModelProperty(value = "血型")
    private String bloodType;

    @ApiModelProperty(value = "是否入党;0:否,1:是")
    private WhetherOrNotEnum isJoinTheParty;

    @ApiModelProperty(value = "删除时间")
    private LocalDateTime deleteTime;

}
