package com.adiljaan.web_admin;

import com.adiljaan.model.entity.AdminUser;
import com.adiljaan.web_admin.service.AdminUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebAdminApplicationTests {

    @Autowired
    private AdminUserService adminUserService;

    @Test
    void contextLoads() {
        List<AdminUser> all = adminUserService.getAll();
        System.out.println(all);
    }

}
