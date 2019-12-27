package com.lxf.service;

import com.lxf.entity.MonthProfit;
import com.lxf.repository.MonthProfitRepository;
import com.lxf.vo.MonthProfitVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<MonthProfitVo> sort(){
        Sort  sort=  Sort.by(Sort.Direction.DESC,"updateTime");
        List<MonthProfit> lists= monthProfitRepository.findAll(sort);
        List<MonthProfitVo> monthProfitVos =lists.stream().map(e->{
            MonthProfitVo monthProfitVo =new MonthProfitVo();
            BeanUtils.copyProperties(e,monthProfitVo);
            return monthProfitVo;
        }).collect(Collectors.toList());
        return monthProfitVos;
    }
public List<MonthProfitVo> findByStockCodeBySort(String stockCode){
    List<Sort.Order> orders=new ArrayList<Sort.Order>();
    orders.add( new Sort.Order(Sort.Direction. DESC, "updateTime"));
    Sort sort=  Sort.by(orders);
    List<MonthProfit> lists= monthProfitRepository.findByAndSort(stockCode,sort);
    List<MonthProfitVo> monthProfitVos =lists.stream().map(e->{
        MonthProfitVo monthProfitVo =new MonthProfitVo();
        BeanUtils.copyProperties(e,monthProfitVo);
        return monthProfitVo;
    }).collect(Collectors.toList());
    return monthProfitVos;
}

}
