package com.mhq0123.officialwebsite.microservice.sms.invoker.email;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/10.
 * desc:
 *
 * 类型字典
 *
 */
public class SmsEmailPath {

    /** base*/
    private final static String BASE                    = "/mapper";

    /** 存储并发送*/
    public final static String STORAGE_AND_SEND         = BASE + "/storageAndSend";
    /** 发送*/
    public final static String SEND                     = BASE + "/send";
}
