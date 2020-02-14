package com.lxf.provider8002.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxf.provider8002.core.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 权限DAO
 * @Author Sans
 * @CreateTime 2019/9/14 15:57
 */
@Mapper
@Component
public interface SysMenuDao extends BaseMapper<SysMenuEntity> {

}