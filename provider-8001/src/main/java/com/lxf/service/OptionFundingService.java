package com.lxf.service;

import com.lxf.repository.OptionFundingRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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


}
