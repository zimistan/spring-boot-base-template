package com.adiljaan.web_admin.service.impl;

import com.adiljaan.model.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.adiljaan.web_admin.service.AdminUserService;
import com.adiljaan.web_admin.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pc
 * @description 针对表【admin_user】的数据库操作Service实现
 * @createDate 2024-07-31 01:16:23
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser>
        implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    public List<AdminUser> getAll() {
        return adminUserMapper.selectList(null);
    }

}




