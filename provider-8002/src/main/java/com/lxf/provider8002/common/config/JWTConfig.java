package com.lxf.provider8002.common.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * JWT配置类
 *
 * @Author Sans
 * @CreateTime 2019/10/1 22:56
 */
@Getter
@Component
@ConfigurationProperties(prefix = "jwt")
//@PropertySource("classpath:application.yml")
public class JWTConfig {
    /**
     * TokenKey
     */
    public static String tokenHeader;
    /**
     * 密钥KEY
     */

    public static String secret;
    /**
     * Token前缀字符
     */
    public static String tokenPrefix;
    /**
     * 过期时间
     */
    public static Integer expiration;
    /**
     * 不需要认证的接口
     */
    public static String antMatchers;


    public void setSecret(String secret) {
        JWTConfig.secret = secret;
    }

    public void setTokenHeader(String tokenHeader) {
        JWTConfig.tokenHeader = tokenHeader;
    }

    public void setTokenPrefix(String tokenPrefix) {
        JWTConfig.tokenPrefix = tokenPrefix;
    }

    public static String getSecret() {
        return secret;
    }

    public static String getTokenHeader() {
        return tokenHeader;
    }

    public static String getTokenPrefix() {
        return tokenPrefix;
    }

    public static Integer getExpiration() {
        return expiration;
    }

    public static String getAntMatchers() {
        return antMatchers;
    }
}