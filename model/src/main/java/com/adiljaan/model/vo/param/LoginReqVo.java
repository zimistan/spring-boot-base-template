package com.adiljaan.model.vo.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "登录参数")
public class LoginReqVo {
    @Schema(description = "用户名")
    private String account;

    @Schema(description = "密码")
    private String password;
}
