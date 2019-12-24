package com.lxf.repository;

import com.lxf.entity.OptionFunding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lxf
 */
@Repository
public interface OptionFundingRepository extends JpaRepository<OptionFunding, Long> {
    @Query(nativeQuery = true,value="SELECT  user_id  userId ,'stock_code' stockCode,'amount','option_type' optionType,'sum','option_time' optionTime FROM option_funding WHERE date_format(option_time,\"%Y-%m-%d\")=?1 ORDER BY  ")
    List<OptionFunding> findOptionFundingByOptionTime(String optionTime);

    /**
     * 查询用户众筹转出明细
     * @param crowdFundingId 众筹id
     * @param userId 用户id
     * @param optionType 类型 0:转出 1：转入
     * @return 用户众筹转出明细列表
     */
    List<OptionFunding> findByCrowdFundingIdAndUserIdAndOptionType(Long crowdFundingId, Long userId, Integer optionType);

    /**
     * 查询众筹所有转入明细
     * @param crowdFundingId 众筹id
     * @param optionType 类型 0:转出 1：转入
     * @return 用户众筹转出明细列表
     */
    List<OptionFunding> findByCrowdFundingIdAndOptionType(Long crowdFundingId, Integer optionType);
}
