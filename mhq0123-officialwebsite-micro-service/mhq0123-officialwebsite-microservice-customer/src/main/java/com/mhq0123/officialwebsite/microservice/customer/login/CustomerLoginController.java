package com.mhq0123.officialwebsite.microservice.customer.login;

import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerDictionary;
import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.login.CustomerLogin;
import com.mhq0123.officialwebsite.microservice.customer.login.service.CustomerLoginService;
import org.mhq0123.springleaf.common.utils.OvalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2017/1/15.
 * desc:    客户登陆
 */
@RestController
public class CustomerLoginController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerLoginController.class);

    @Autowired
    private CustomerLoginService customerLoginService;

    /**
     * 登陆
     * @param customerLogin
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathLogin.LOGIN)
    public int login(@RequestBody CustomerLogin customerLogin) {
        // 校验
        if(null == customerLogin) {
            throw new IllegalArgumentException("登陆对象不可为空");
        }
        // 栏位校验
        OvalUtils.validate(customerLogin, "insert");

        return customerLoginService.login(customerLogin);
    }

    /**
     * 登出
     * @param loginId
     * @return
     */
    @PostMapping(MicroServiceCustomerDictionary.PathLogin.LOGOUT)
    public int logout(@RequestParam("loginId") int loginId) {
        // 校验
        if(loginId < 1) {
            throw new IllegalArgumentException("登陆索引编号不可为空");
        }

        return customerLoginService.logout(loginId);
    }
}
