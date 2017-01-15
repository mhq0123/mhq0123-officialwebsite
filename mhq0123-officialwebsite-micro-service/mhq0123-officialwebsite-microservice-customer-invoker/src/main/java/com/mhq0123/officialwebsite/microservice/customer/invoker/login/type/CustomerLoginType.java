package com.mhq0123.officialwebsite.microservice.customer.invoker.login.type;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/30.
 * desc:
 *
 * 类型字典
 *
 */
public class CustomerLoginType {

    /** 登陆系统来源*/
    public enum SourceSystem {
        BLOG, ASSISTANT, FORUM, MICROVIEDO
    }

    /** 登陆设备类型*/
    public enum TerminalType {
        PC, IOS, ANDROID
    }

    /** 登陆状态*/
    public enum Status {
        ON_LINE, OFF_LINE, LOGOUT
    }
}
