package com.mhq0123.officialwebsite.microservice.sms.email;

import com.mhq0123.officialwebsite.microservice.sms.email.service.SmsEmailService;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.SmsEmailPath;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.bean.SmsEmail;
import org.mhq0123.springleaf.common.utils.OvalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/13.
 * desc:    邮箱服务
 */
@RestController
public class SmsEmailController {

    @Autowired
    private SmsEmailService smsEmailService;

    /**
     * 存储并发送
     * @param smsEmail
     * @return
     */
    @PostMapping(SmsEmailPath.STORAGE_AND_SEND)
    public boolean storageAndSend(@RequestBody SmsEmail smsEmail) {
        // 校验
        OvalUtils.validate(smsEmail, "insert");

        return  smsEmailService.storageAndSend(smsEmail);
    }

    /**
     * 不存储直接发送
     * @param smsEmail
     * @return
     */
    @PostMapping(SmsEmailPath.SEND)
    public boolean send(@RequestBody SmsEmail smsEmail) {
        // 校验
        OvalUtils.validate(smsEmail, "insert");

        return smsEmailService.send(smsEmail);
    }
}
