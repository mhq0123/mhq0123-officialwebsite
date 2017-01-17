package com.mhq0123.officialwebsite.microservice.customer.invoker.login;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/15.
 * desc:
 *
 * 类型字典
 *
 */
public class CustomerLoginPath {

    /** base*/
    private final static String BASE            = "/login";

    /** 登陆*/
    public final static String LOGIN            = BASE + "/login";
    /** 自动登陆*/
    public final static String SELECT_BY_ID     = BASE + "/selectById";
    /** 登出*/
    public final static String LOGOUT           = BASE + "/logout";

}
