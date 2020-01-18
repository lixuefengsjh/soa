package com.lxf.provider8002.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxf.provider8002.core.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 用户与角色关系DAO
 * @Author Sans
 * @CreateTime 2019/9/14 15:57
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {
	
}
