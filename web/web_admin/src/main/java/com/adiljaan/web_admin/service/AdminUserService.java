package com.adiljaan.web_admin.service;

import com.adiljaan.model.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author pc
 * @description 针对表【admin_user】的数据库操作Service
 * @createDate 2024-07-31 01:16:23
 */
public interface AdminUserService extends IService<AdminUser> {
    List<AdminUser> getAll();
}
