package com.adiljaan.web_admin.service;

import cloud.tianai.captcha.application.ImageCaptchaApplication;
import cloud.tianai.captcha.application.vo.CaptchaResponse;
import cloud.tianai.captcha.application.vo.ImageCaptchaVO;
import cn.dev33.satoken.stp.SaTokenInfo;
import com.adiljaan.model.entity.AdminUser;
import com.adiljaan.model.vo.param.LoginReqVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author pc
 * @description 针对表【admin_user】的数据库操作Service
 * @createDate 2024-07-31 01:16:23
 */
public interface AdminUserService extends IService<AdminUser> {
    SaTokenInfo login(LoginReqVo loginReqVo);

    CaptchaResponse<ImageCaptchaVO> getCaptcha();

    List<AdminUser> getAll();
}
