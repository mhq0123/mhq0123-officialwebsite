package com.mhq0123.officialwebsite.microservice.sms.invoker;

import com.mhq0123.officialwebsite.microservice.sms.invoker.bean.SmsEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/29.
 * desc:
 */
@Component
public class MicroServiceSmsHystrix implements MicroServiceSmsClient {

    private final static Logger logger = LoggerFactory.getLogger(MicroServiceSmsHystrix.class);

    @Override
    public boolean emailStorageAndSend(SmsEmail sendBean) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public boolean emailSend(SmsEmail sendBean) {
        throw new RuntimeException("服务器繁忙");
    }
}
