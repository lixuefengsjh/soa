package com.lxf.service;

import com.lxf.entity.OptionFunding;
import com.lxf.repository.OptionFundingRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author lxf
 */
@Service
public class OptionFundingService {

    /**
     * 众筹操作明细
     */
    @Resource
    private OptionFundingRepository optionFundingRepository;
    @Async("defaultThreadPool")
    public List<OptionFunding> findOptionFundingByOptionTime(){
        LocalDate localDate=LocalDate.now();
        String today=localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(Thread.currentThread().getName());
        return optionFundingRepository.findOptionFundingByOptionTime(today);
    }


}
