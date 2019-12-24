package com.lxf;

import com.lxf.common.BaseEntity;
import com.lxf.enums.OptionEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class providerApplication_8001 {

    public static void main(String[] args) {
        SpringApplication.run(providerApplication_8001.class, args);

    }

    /**
     * 众筹账户操作明细
     * @author lxf
     */
    @Entity
    @Data
    @Accessors(chain = true)
    @NoArgsConstructor
    public static class OptionFunding extends BaseEntity {

      /**
       * 转出类型
       */
      public static final Integer OPTION_TYPE_OUT = 0;

      /**
       * 转入类型
       */
      public static final Integer OPTION_TYPE_IN = 0;

      @Column(columnDefinition = "bigint COMMENT '用户名'", nullable = false)
      private Long userId;

      @Column(columnDefinition = "decimal COMMENT '数量'", nullable = false)
      private BigDecimal amount;

      @Column(columnDefinition = "tinyint COMMENT '操作类型0:转出 1：转入'", nullable = false)
      private OptionEnum optionType;

      @Column(columnDefinition = "decimal COMMENT '账户余额'", nullable = false)
      private BigDecimal sum;

      @Column(columnDefinition = "datetime COMMENT '账号余额'", nullable = false)
      private Date optionTime;

      @Column(columnDefinition = "char(32) COMMENT '股权代码'", nullable = false)
      private String stockCode;

      @Column(columnDefinition = "varchar(50) COMMENT '关联众筹'", nullable = false)
      private Long crowdFundingId;
    }
}
