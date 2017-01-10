package com.mhq0123.officialwebsite.microservice.sms.invoker;

import org.mhq0123.springleaf.core.annotation.Comment;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/10.
 * desc:
 *
 * 类型字典
 *
 */
public class MicroServiceSmsDictionary {

    /** 服务id*/
    public static final String SERVICE_ID = "mhq0123-officialwebsite-microservice-sms";

    /** 请求路径 - 邮箱操作*/
    public static class PathEmail {
        /** base*/
        public final static String BASE                     = "/email";
        /** 存储并发送*/
        public final static String STORAGE_AND_SEND         = BASE + "/storageAndSend";
        /** 发送*/
        public final static String SEND                     = BASE + "/send";
    }

    /** 邮件主题类型*/
    public enum EmailSubject {
        @Comment(desc="邮箱验证")
        EMAIL_VERIFICATION
    }
}