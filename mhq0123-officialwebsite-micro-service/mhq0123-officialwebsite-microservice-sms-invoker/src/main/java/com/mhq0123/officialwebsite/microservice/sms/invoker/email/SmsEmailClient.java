package com.mhq0123.officialwebsite.microservice.sms.invoker.email;

import com.mhq0123.officialwebsite.microservice.sms.invoker.SmsInvokerConstant;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.bean.SmsEmail;
import com.mhq0123.officialwebsite.microservice.sms.invoker.email.hystrix.SmsEmailHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/15.
 * desc:    接口定义 邮件操作
 */
@FeignClient(value = SmsInvokerConstant.SERVICE_ID, fallback = SmsEmailHystrix.class)
public interface SmsEmailClient {

    /**
     * 邮箱操作 - 存储并发送
     * @param smsEmail
     * @return
     */
    @RequestMapping(value = SmsEmailPath.STORAGE_AND_SEND, method = RequestMethod.POST)
    boolean storageAndSend(@RequestBody SmsEmail smsEmail);

    /**
     * 邮箱操作 - 发送
     * @param smsEmail
     * @return
     */
    @RequestMapping(value = SmsEmailPath.SEND, method = RequestMethod.POST)
    boolean send(SmsEmail smsEmail);
}
