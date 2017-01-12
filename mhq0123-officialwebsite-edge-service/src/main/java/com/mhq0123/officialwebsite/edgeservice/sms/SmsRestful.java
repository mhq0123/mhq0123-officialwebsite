package com.mhq0123.officialwebsite.edgeservice.sms;

import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
import org.mhq0123.springleaf.common.utils.OvalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/12.
 * desc:
 */
@RestController
public class SmsRestful {

    private static final Logger logger = LoggerFactory.getLogger(SmsRestful.class);

    @PostMapping(SmsPath.SEND_VERIFICATION_CODE_BY_EMAIL)
    public boolean sendVerificationCodeByEmail(@RequestParam("email") String email) {
        // 检验
        OvalUtils.validate(new CustomerAccount().setEmail(email), "email");
        // 生成验证码、并缓存
        // 发送

        return true;
    }
}
