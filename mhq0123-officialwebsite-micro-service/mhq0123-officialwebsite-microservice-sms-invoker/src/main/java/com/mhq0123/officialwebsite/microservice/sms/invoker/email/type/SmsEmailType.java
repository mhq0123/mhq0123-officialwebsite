package com.mhq0123.officialwebsite.microservice.sms.invoker.email.type;

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
public class SmsEmailType {

    /** 邮件主题类型*/
    public enum Subject {
        @Comment(code = "verificationCode", desc = "验证码通知")
        VERIFICATION_CODE
    }

    /** 邮件状态*/
    public enum Status {
        SUCCESS, FAILURE, EXCEPTION, CONFIRM_SUCCESS, CONFIRM_FAILURE
    }
}
