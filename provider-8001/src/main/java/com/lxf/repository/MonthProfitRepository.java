package com.lxf.repository;

import com.lxf.entity.MonthProfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 月度销售额记录
 * @author lxf
 */
public interface MonthProfitRepository extends JpaRepository<MonthProfit, Long> {
    /**
     * 根据stockCode 获取销售额
     * @param stockCode 股权代码
     * @return
     */
    List<MonthProfit> findAllByStockCodeOrderByRecordTime(String stockCode);

    /**
     * 批量
     *
     * @param id 主键
     */
    @Modifying
    @Transactional
    void deleteByIdIn(List<Long>  id) ;

    /**
     *修改
     * @param stockCode 获取销售额
     * @param salesAmount 数量
     * @param percentage 比列
     * @param recordTime 月度
     */
    @Query(nativeQuery = true, value = "UPDATE  bonus_count SET  sales_amount=?2,percentage=?3,where stockCode=?1 and record_time=?4")
    void updateMonthProfit(String stockCode,
                           String salesAmount,
                           String percentage,
                           String recordTime);
}
