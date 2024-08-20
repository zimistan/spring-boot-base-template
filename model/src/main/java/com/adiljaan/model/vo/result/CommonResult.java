package com.adiljaan.model.vo.result;

import com.adiljaan.model.enums.GlobalErrorCode;
import com.adiljaan.model.exception.ErrorCode;
import com.adiljaan.model.exception.ServiceException;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 通用返回
 *
 * @param <T> 数据泛型
 * @author <a href="https://github.com/XiaoZhangCode">XiaoZhangCode</a>
 */
@Data
@Tag(name = "CommonResult")
public class CommonResult<T> implements Serializable {

    /**
     * 错误码
     *
     * @see ErrorCode#getClass()
     */
    @Schema(description = "业务状态", example = "0")
    private Integer code;
    /**
     * 返回数据
     */
    @Schema(description = "返回数据", example = "null")
    private T data;
    /**
     * 错误提示，用户可阅读
     *
     * @see ErrorCode#getMsg() ()
     */
    @Schema(description = "消息提示", example = "null")
    private String msg;


    public static <T> CommonResult<T> error( String message) {
        CommonResult<T> result = new CommonResult<>();
        result.code = GlobalErrorCode.FAIL.getCode();
        result.msg = message;
        return result;
    }

    public static <T> CommonResult<T> error(Integer code, String message) {
        Assert.isTrue(!GlobalErrorCode.SUCCESS.getCode().equals(code), "code 必须是错误的！");
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = message;
        return result;
    }

    public static <T> CommonResult<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = GlobalErrorCode.SUCCESS.getCode();
        result.data = data;
        result.msg = GlobalErrorCode.SUCCESS.getMsg();
        return result;
    }

    public static <T> CommonResult<T> error(ServiceException serviceException) {
        return error(serviceException.getCode(), serviceException.getMessage());
    }

}
