package com.adiljaan.web_admin.mapper;

import com.adiljaan.model.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminUserMapperTest {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Test
    void test() {
        List<AdminUser> adminUsers = adminUserMapper.selectList(null);
        System.out.println(adminUsers);
    }
}