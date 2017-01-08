package com.mhq0123.officialwebsite.microservice.customer.account.service;

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
    public int insert(CustomerAccount insertBean) {
        // 唯一性校验用户名
        if(null != customerAccountMapper.selectByUniqueField(MicroServiceCustomerDictionary.EnumAccountUniqueField.NAME, insertBean.getAccountName())) {
            throw new IllegalArgumentException("用户名已存在");
        }
        // 唯一性校验邮箱
        if(null != customerAccountMapper.selectByUniqueField(MicroServiceCustomerDictionary.EnumAccountUniqueField.EMAIL, insertBean.getEmail())) {
            throw new IllegalArgumentException("邮箱已存在");
        }
        // 加密密码
        insertBean.setPassword(CipherUtils.encryptPassword(insertBean.getAccountName(), insertBean.getPassword()));
        // 初始状态赋值-待验证
        insertBean.setStatus(MicroServiceCustomerDictionary.EnumAccountStatus.INIT);
        // 写入
        return customerAccountMapper.insert(insertBean);
    }

    /**
     * 根据唯一字段查询
     * @param uniqueField
     * @param fieldValue
     * @return
     */
    public CustomerAccount selectByUniqueField(MicroServiceCustomerDictionary.EnumAccountUniqueField uniqueField, String fieldValue) {
        // 查询
        return customerAccountMapper.selectByUniqueField(uniqueField, fieldValue);
    }

}
