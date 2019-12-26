package com.lxf.service;

import com.lxf.entity.MonthProfit;
import com.lxf.repository.MonthProfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 月度销售额操作
 *
 * @author lxf
 */
@Service
public class MonthProfitService {
    @Autowired
    private MonthProfitRepository monthProfitRepository;

    public List<MonthProfit> findAllByStockCode(String stockCode) {
        return monthProfitRepository.findAllByStockCodeOrderByRecordTime(stockCode);
    }

    public void saveMonthProfit(MonthProfit monthProfit) {
        monthProfitRepository.save(monthProfit);
    }

    public void deleteMonthProfitById(List<Long> ids) {
        monthProfitRepository.deleteByIdIn(ids);
    }

    public void updateMonthProfit(MonthProfit monthProfit){
        monthProfitRepository.save(monthProfit);
    }

}
