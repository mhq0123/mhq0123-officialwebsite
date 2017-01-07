package com.mhq0123.officialwebsite.microservice.customer.account;

import com.mhq0123.officialwebsite.microservice.customer.account.service.CustomerAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/7.
 * desc:    客户账户
 */
@RestController
public class CustomerAccountController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAccountController.class);

    @Autowired
    private CustomerAccountService customerAccountService;

    // 验证用户名邮箱是否已存在

    public boolean checkExists() {

    }
    // 注册新用户

    // 冻结用户

    // 更新用户

    // 查询单个用户


}
