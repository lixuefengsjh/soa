package com.lxf.provider8002.security.sms;

import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lxf
 * @date 2020/1/18 17:03
 * @modified
 * @description 短信登录过滤器
 */
public class SmsAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    public static final String SPRING_SECURITY_FORM_PHONE_KEY = "phone";
    private String phoneParameter = "phone";
    private boolean postOnly = true;

    public SmsAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login/sms", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String phone = this.obtainPhone(request);
            if (phone == null) {
                phone = "";
            }
            SmsAuthenticationToken authRequest = new SmsAuthenticationToken(phone);
            this.setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }

    @Nullable
    protected String obtainPhone(HttpServletRequest request) {
        return request.getParameter(this.phoneParameter);
    }


    protected void setDetails(HttpServletRequest request, SmsAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    public void setPhoneParameter(String phoneParameter) {
        Assert.hasText(phoneParameter, "phoneParameter parameter must not be empty or null");
        this.phoneParameter = phoneParameter;
    }



    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getPhoneParameter() {
        return this.phoneParameter;
    }

}
