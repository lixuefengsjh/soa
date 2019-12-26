package com.lxf.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

/**
 * 校验发生错误抛出异常
 *
 * @author Chinhin
 * 2019-08-08
 */
@Getter @Setter
public class TcmartErrorException extends RuntimeException {

    /**
     * 错误编号，对应i18n里面的 key
     */
    private String msgKey;

    /**
     * 如果有值得话，将不会取i18n里面的错误信息
     */
    private String msg;

    /**
     * 错误信息的参数，用,隔开
     */
    private String errorArgs;

    private TcmartErrorException(){}

    public static TcmartErrorException valueOf(String msgKey) {
        TcmartErrorException exception = new TcmartErrorException();
        exception.setMsgKey(msgKey);
        return exception;
    }

    public static TcmartErrorException valueOf(String msgKey, String[] errorArgs) {
        TcmartErrorException exception = new TcmartErrorException();
        exception.setMsgKey(msgKey);
        exception.setErrorArgs(StringUtils.arrayToDelimitedString(errorArgs, Constants.COMMA));
        return exception;
    }

    public static TcmartErrorException valueOf(String msgKey, String msg) {
        TcmartErrorException exception = valueOf(msgKey);
        exception.setMsg(msg);
        return exception;
    }

}
