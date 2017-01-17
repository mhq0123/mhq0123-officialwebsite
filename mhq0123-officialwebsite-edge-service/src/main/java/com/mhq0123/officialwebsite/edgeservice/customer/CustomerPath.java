package com.mhq0123.officialwebsite.edgeservice.customer;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/10.
 * desc:
 */
public class CustomerPath {

    /** 客户操作*/
    private static final String BASE                = "/customer";

    /** 检查是否存在，不存在则发验证码*/
    public static final String CHECK_EXIST_AND_SEND_VERIFICATION_CODE   = BASE + "/checkExistAndSendVerificationCode";
    /** 注册*/
    public static final String REGISTER             = BASE + "/register";
    /** 登陆*/
    public static final String LOGIN                = BASE + "/login";
    /** 自动登陆*/
    public static final String AUTO_LOGIN           = BASE + "/autoLogin";
    /** 登出*/
    public static final String LOGOUT                = BASE + "/logout";
    /** 检查是否匹配，匹配上则发验证码*/
    public static final String CHECK_MATCH_AND_SEND_VERIFICATION_CODE   = BASE + "/checkMatchAndSendVerificationCode";
    /** 找回密码*/
    public static final String RESET_PASSWORD   = BASE + "/resetPassword";
}
