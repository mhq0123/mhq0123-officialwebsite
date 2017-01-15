package com.mhq0123.officialwebsite.microservice.customer.login.service;

import com.mhq0123.officialwebsite.microservice.customer.invoker.login.bean.CustomerLogin;
import com.mhq0123.officialwebsite.microservice.customer.invoker.login.bean.CustomerLoginHistory;
import com.mhq0123.officialwebsite.microservice.customer.invoker.login.type.CustomerLoginType;
import com.mhq0123.officialwebsite.microservice.customer.login.mapper.CustomerLoginHistoryMapper;
import com.mhq0123.officialwebsite.microservice.customer.login.mapper.CustomerLoginMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/15.
 * desc:    客户登陆
 */
@Service
public class CustomerLoginService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerLoginService.class);

    @Autowired
    private CustomerLoginMapper customerLoginMapper;
    @Autowired
    private CustomerLoginHistoryMapper customerLoginHistoryMapper;

    /**
     * 登陆
     * @param customerLogin
     * @return 登陆记录主键
     */
    public int login(CustomerLogin customerLogin) {
        // 赋值
        customerLogin.setStatus(CustomerLoginType.Status.ON_LINE);
        // 写入登陆表
        customerLoginMapper.insert(customerLogin);
        // 返回登陆记录主键
        return customerLogin.getLoginId();
    }

    /**
     * 登出
     * @param loginId 登陆编号
     * @return
     */
    @Transactional
    public int logout(int loginId) {
        // 查询当前登陆对象
        CustomerLogin selectBean = customerLoginMapper.selectById(loginId);
        if(null == selectBean) {
            throw new IllegalArgumentException("登陆对象不存在");
        }

        // 写入登陆历史表
        CustomerLoginHistory insertBean = new CustomerLoginHistory();
        BeanUtils.copyProperties(selectBean, insertBean);
        insertBean.setStatus(CustomerLoginType.Status.LOGOUT);
        customerLoginHistoryMapper.insert(insertBean);

        // 删除当前登陆表
        return customerLoginMapper.deleteById(loginId);
    }
}
