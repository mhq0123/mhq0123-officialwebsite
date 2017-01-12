package com.mhq0123.officialwebsite.edgeservice.sms;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/12.
 * desc:
 */
public class SmsPath {

    /** 短讯操作*/
    private static final String BASE = "/sms";
    /** 发送邮箱验证码*/
    public static final String SEND_VERIFICATION_CODE_BY_EMAIL = BASE + "/sendVerificationCodeByEmail";
}
