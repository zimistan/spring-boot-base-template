package com.adiljaan.web_admin.service.impl;

import cloud.tianai.captcha.application.ImageCaptchaApplication;
import cloud.tianai.captcha.application.vo.CaptchaResponse;
import cloud.tianai.captcha.application.vo.ImageCaptchaVO;
import cloud.tianai.captcha.common.constant.CaptchaTypeConstant;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.adiljaan.model.entity.AdminUser;
import com.adiljaan.model.enums.UserStatus;
import com.adiljaan.model.vo.param.LoginReqVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.adiljaan.web_admin.service.AdminUserService;
import com.adiljaan.web_admin.mapper.AdminUserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.adiljaan.model.enums.GlobalErrorCode.*;
import static com.adiljaan.model.exception.util.ServiceExceptionUtil.exception;

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

    @Autowired
    private ImageCaptchaApplication imageCaptchaApplication;

    public List<AdminUser> getAll() {
        return adminUserMapper.selectList(null);
    }

    @Override
    public SaTokenInfo login(LoginReqVo loginReqVo) {
        if (StringUtils.isBlank(loginReqVo.getAccount())) {
            throw exception(BAD_REQUEST);
        }

        if (StringUtils.isBlank(loginReqVo.getPassword())) {
            throw exception(BAD_REQUEST);
        }

        LambdaQueryWrapper<AdminUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AdminUser::getUserName, loginReqVo.getAccount());
        AdminUser adminUser = adminUserMapper.selectOne(queryWrapper);

        if (adminUser == null) {
            throw exception(USER_NOT_EXIST);
        }

        System.out.println("跑到了这里");

        if (adminUser.getUserStatus().equals(UserStatus.DISABLE)) {
            throw exception(USER_NOT_NORMAL);
        }

        if (!adminUser.getUserPassword().equals(DigestUtils.md5Hex(loginReqVo.getPassword()))) {
            throw exception(USER_ACCOUNT_ERROR);
        }


        StpUtil.login(adminUser.getId());
        return StpUtil.getTokenInfo();
    }

    @Override
    public CaptchaResponse<ImageCaptchaVO> getCaptcha() {
        CaptchaResponse<ImageCaptchaVO> response = imageCaptchaApplication.generateCaptcha(CaptchaTypeConstant.SLIDER);
        return response;
    }

}




