package com.mhq0123.officialwebsite.assistant.service.databank;

import com.mhq0123.officialwebsite.assistant.client.AssistantServicePath;
import com.mhq0123.officialwebsite.assistant.client.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: officialwebsite
 * author:  mhq0123
 * date:    2016/12/25.
 * desc:
 */
@RestController
public class DataBankService {

    private final static Logger logger = LoggerFactory.getLogger(DataBankService.class);

    @GetMapping(AssistantServicePath.SELECT_USER_BY_USER_ID)
    public User selectUserByUserId() {
        User user = new User();

        user.setUserName("mhq0123");
        user.setPassword("123456");

        return user;
    }
}
