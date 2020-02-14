package com.lxf.provider8002;

import com.lxf.provider8002.core.dao.SysMenuDao;
import com.lxf.provider8002.core.service.impl.SysUserRoleServiceImpl;
import com.lxf.provider8002.core.service.impl.SysUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Provider8002ApplicationTests {
@Autowired
    private SysMenuDao sysMenuDao;
    @Test
    void contextLoads() {
       sysMenuDao.selectById(1);
    }

}
