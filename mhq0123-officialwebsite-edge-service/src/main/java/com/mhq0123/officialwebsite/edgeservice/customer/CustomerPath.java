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
    /** 注册*/
    public static final String REGISTER             = BASE + "/register";
    /** 登陆*/
    public static final String LOGIN                = BASE + "/login";
    /** 检查用户名*/
    public static final String CHECK_ACCOUNT_NAME   = BASE + "/checkAccountName";
}
