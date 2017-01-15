package com.mhq0123.officialwebsite.microservice.sms.invoker.email.hystrix;

import com.mhq0123.officialwebsite.microservice.sms.invoker.email.SmsEmailClient;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.bean.SmsEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/29.
 * desc:
 */
@Component
public class SmsEmailHystrix implements SmsEmailClient {

    private final static Logger logger = LoggerFactory.getLogger(SmsEmailHystrix.class);

    @Override
    public boolean storageAndSend(@RequestBody SmsEmail smsEmail) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public boolean send(SmsEmail smsEmail) {
        throw new RuntimeException("服务器繁忙");
    }
}
