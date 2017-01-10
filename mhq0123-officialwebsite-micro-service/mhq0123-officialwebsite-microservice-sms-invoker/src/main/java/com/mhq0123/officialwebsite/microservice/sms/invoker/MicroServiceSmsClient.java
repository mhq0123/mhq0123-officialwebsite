package com.mhq0123.officialwebsite.microservice.sms.invoker;

import com.mhq0123.officialwebsite.microservice.sms.invoker.bean.SmsEmail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/28.
 * desc:    接口定义
 */
@FeignClient(value = MicroServiceSmsDictionary.SERVICE_ID, fallback = MicroServiceSmsHystrix.class)
public interface MicroServiceSmsClient {

    /**
     * 邮箱操作 - 存储并发送
     * @param sendBean
     * @return
     */
    @PostMapping(MicroServiceSmsDictionary.PathEmail.STORAGE_AND_SEND)
    boolean emailStorageAndSend(SmsEmail sendBean);

    /**
     * 邮箱操作 - 发送
     * @param sendBean
     * @return
     */
    @PostMapping(MicroServiceSmsDictionary.PathEmail.SEND)
    boolean emailSend(SmsEmail sendBean);
}
