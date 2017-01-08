package com.mhq0123.officialwebsite.microservice.customer.account.service;

import com.alibaba.fastjson.JSONObject;
import com.mhq0123.officialwebsite.microservice.customer.account.mapper.CustomerAccountMapper;
import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerDictionary;
import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
import com.mhq0123.springleaf.common.utils.CipherUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/29.
 * desc:
 */
@Service
public class CustomerAccountService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAccountService.class);

    @Autowired
    private CustomerAccountMapper customerAccountMapper;

    /**
     * 注册服务
     * @param insertBean
     * @return
     */
    public int accountInsert(CustomerAccount insertBean) {
        logger.info(">>>>>>>>>>>>>>接收参数insertBean:{}", JSONObject.toJSONString(insertBean, true));

        // 校验
        if(null == insertBean) {
            throw new IllegalArgumentException("insertBean对象不可为空");
        }
        // 栏位校验 TODO 引入校验框架

        // 唯一性校验

        // 加密密码
        insertBean.setPassword(CipherUtils.encryptPassword(insertBean.getAccountName(), insertBean.getPassword()));
        // 初始状态赋值-待验证
        insertBean.setStatus(MicroServiceCustomerDictionary.AccountStatus.INIT);

        logger.info(">>>>>>>>>>>>>>请求参数insertBean:{}", JSONObject.toJSONString(insertBean, true));
        int count = customerAccountMapper.insert(insertBean);
        logger.info(">>>>>>>>>>>>>>返回结果count:{}", count);

        return count;
    }

}
