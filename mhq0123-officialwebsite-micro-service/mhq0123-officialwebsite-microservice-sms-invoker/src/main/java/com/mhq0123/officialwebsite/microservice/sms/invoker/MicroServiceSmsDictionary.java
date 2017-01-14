package com.mhq0123.officialwebsite.microservice.sms.invoker;

import org.mhq0123.springleaf.common.annotation.Comment;

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

    public static final String EMAIL_FROM = "mhq0123_noreply@126.com";

    /** 请求路径 - 邮箱操作*/
    public static class PathEmail {
        /** base*/
        public final static String BASE                     = "/mapper";
        /** 存储并发送*/
        public final static String STORAGE_AND_SEND         = BASE + "/storageAndSend";
        /** 发送*/
        public final static String SEND                     = BASE + "/send";
    }

    /** 邮件主题类型*/
    public enum EmailSubject {
        @Comment(code = "verificationCode", desc = "mhq0123 验证码")
        VERIFICATION_CODE
    }

    /** 邮件状态*/
    public enum EmailStatus {
        SUCCESS, FAILURE, EXCEPTION, CONFIRM_SUCCESS, CONFIRM_FAILURE
    }
}
