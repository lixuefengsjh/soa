package com.lxf.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Administrator
 */
@ApiModel
@NoArgsConstructor
@Getter @Setter
public class HttpResult<T> implements Serializable {

    @ApiModelProperty("是否成功")
    private boolean success;

    @ApiModelProperty("返回结果")
    private T result;

    @ApiModelProperty("响应时间")
    private Long timestamp;

    @ApiModelProperty("错误码")
    private String errorCode;

    @ApiModelProperty("错误消息")
    private String error;

    // 错误消息的参数，用半角逗号隔开
    @ApiModelProperty(hidden = true)
    private String errorArgs;

    // 网关通过I18N获取错误信息
    public static <T> HttpResult<T> error(String errorCode) {
        return new HttpResult<>(null, false, Constants.EMPTY, errorCode, Constants.EMPTY);
    }

    // 网关通过I18N获取错误信息
    public static <T> HttpResult<T> error(String errorCode, String errorArgs) {
        return new HttpResult<>(null, false, Constants.EMPTY, errorCode, errorArgs);
    }

    // 不网关通过I18N获取错误信息
    public static <T> HttpResult<T> errorMsg(String errorMsg) {
        return new HttpResult<>(null, false, errorMsg, Constants.EMPTY, Constants.EMPTY);
    }

    public static <T> HttpResult<T> success(T result) {
        return new HttpResult<>(result, true, Constants.EMPTY, Constants.EMPTY, Constants.EMPTY);
    }

    public static <T> HttpResult<T> success() {
        return new HttpResult<>(null, true, Constants.EMPTY, Constants.EMPTY, Constants.EMPTY);
    }

    private HttpResult(T result, Boolean success, String error, String errorCode, String errorArgs) {
        this.success = success;
        this.result = result;
        this.error = error;
        this.errorCode = errorCode;
        this.errorArgs = errorArgs;
        this.timestamp = System.currentTimeMillis();
    }

}
