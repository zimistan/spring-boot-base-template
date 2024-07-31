package com.adiljaan.web_admin.controller;

import com.adiljaan.model.entity.AdminUser;
import com.adiljaan.web_admin.mapper.AdminUserMapper;
import com.adiljaan.web_admin.service.AdminUserService;
import com.adiljaan.web_admin.service.impl.AdminUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("")
    public List<AdminUser> getAllUser() {
        return adminUserService.getAll();
    }
}
