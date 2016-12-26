package com.mhq0123.officialwebsite.assistant.client;

import com.mhq0123.officialwebsite.assistant.client.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/25.
 * desc:
 */
@Component
public class AssistantServiceHystrix implements AssistantServiceClient {

    private final static Logger logger = LoggerFactory.getLogger(AssistantServiceHystrix.class);

    @Override
    public User selectUserByUserId() {
        logger.info(this.getClass() + " is error, hold on...");
        return null;
    }
}
