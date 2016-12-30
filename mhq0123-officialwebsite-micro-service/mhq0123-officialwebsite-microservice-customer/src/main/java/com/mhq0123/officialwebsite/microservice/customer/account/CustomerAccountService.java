package com.mhq0123.officialwebsite.microservice.customer.account;

import com.alibaba.fastjson.JSONObject;
import com.mhq0123.officialwebsite.microservice.customer.account.bean.CustomerAccount;
import com.mhq0123.officialwebsite.microservice.customer.account.mapper.CustomerAccountMapper;
import com.mhq0123.officialwebsite.microservice.customer.invoker.type.CustomerTypeDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/29.
 * desc:
 */
@RestController
public class CustomerAccountService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAccountService.class);

    @Autowired
    private CustomerAccountMapper customerAccountMapper;

    /**
     * 注册服务
     * @param registerBean
     * @return
     */
    public int register(CustomerAccount registerBean) {
        logger.info(">>>>>>>>>>>>>>客户注册registerBean:{}", JSONObject.toJSONString(registerBean, true));

        // 校验
        if(null == registerBean) {
            throw new IllegalArgumentException("注册对象不可为空");
        }
        // TODO 引入校验框架

        // 加密密码

        // 初始赋值
        registerBean.setStatus(CustomerTypeDictionary.AccountStatus.INIT);
        return customerAccountMapper.insert(registerBean);
    }

}
