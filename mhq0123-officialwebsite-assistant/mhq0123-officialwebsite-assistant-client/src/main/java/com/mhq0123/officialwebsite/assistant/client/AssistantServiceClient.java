package com.mhq0123.officialwebsite.assistant.client;

import com.mhq0123.officialwebsite.assistant.client.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * project: officialwebsite
 * author:  mhq0123
 * date:    2016/12/25.
 * desc: 接口定义
 */
@FeignClient(value = AssistantServicePath.SERVICE_ID, fallback = AssistantServiceHystrix.class)
public interface AssistantServiceClient {

    @GetMapping(AssistantServicePath.SELECT_USER_BY_USER_ID)
    User selectUserByUserId();
}
