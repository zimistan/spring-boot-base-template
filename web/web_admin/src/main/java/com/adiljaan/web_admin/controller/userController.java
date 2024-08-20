package com.adiljaan.web_admin.controller;

import cloud.tianai.captcha.application.ImageCaptchaApplication;
import cloud.tianai.captcha.application.vo.CaptchaResponse;
import cloud.tianai.captcha.application.vo.ImageCaptchaVO;
import cn.dev33.satoken.stp.SaTokenInfo;
import com.adiljaan.model.entity.AdminUser;
import com.adiljaan.model.vo.param.LoginReqVo;
import com.adiljaan.model.vo.result.CommonResult;
import com.adiljaan.web_admin.service.AdminUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "用户信息管理")
public class userController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("")
    @Operation(summary = "获取所有用户")
    public List<AdminUser> getAllUser() {
        return adminUserService.getAll();
    }

    @PostMapping("login")
    @Operation(summary = "用户登录")
    public CommonResult loginUser(@RequestBody() LoginReqVo loginReqVo) {
        System.out.println(loginReqVo.toString());
        SaTokenInfo tokenInfo = adminUserService.login(loginReqVo);
        return CommonResult.success(tokenInfo);
    }

    @GetMapping("getCaptcha")
    @Operation(summary = "获取行为验证码")
    public CaptchaResponse<ImageCaptchaVO> getCaptcha() {
        CaptchaResponse<ImageCaptchaVO> imageCaptchaApplication = adminUserService.getCaptcha();
        return imageCaptchaApplication;
    }
}
