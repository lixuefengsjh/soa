package com.lxf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxf.common.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
}
