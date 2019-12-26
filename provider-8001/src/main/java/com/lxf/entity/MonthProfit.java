package com.lxf.entity;

import com.lxf.common.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 分红明细信息
 * @author lxf
 */
@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class MonthProfit extends BaseEntity {
    @Column(columnDefinition = "char(32) COMMENT '股权代码'", nullable = false)
    private String stockCode;

    @Column(columnDefinition = "decimal COMMENT '销售额'", nullable = false)
    private BigDecimal salesAmount;

    @Column(columnDefinition = "double COMMENT '分红比例'", nullable = false)
    private Double percentage;

    @Column(columnDefinition = "date COMMENT '月度'", nullable = false)
    private LocalDate recordTime;
}
