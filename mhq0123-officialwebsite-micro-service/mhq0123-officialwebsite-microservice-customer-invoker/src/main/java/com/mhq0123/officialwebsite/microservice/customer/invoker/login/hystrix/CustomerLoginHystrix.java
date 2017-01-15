package com.mhq0123.officialwebsite.microservice.customer.invoker.login.hystrix;

import com.mhq0123.officialwebsite.microservice.customer.invoker.login.CustomerLoginClient;
import com.mhq0123.officialwebsite.microservice.customer.invoker.login.bean.CustomerLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/29.
 * desc:
 */
@Component
public class CustomerLoginHystrix implements CustomerLoginClient {

    private final static Logger logger = LoggerFactory.getLogger(CustomerLoginHystrix.class);

    @Override
    public int login(@RequestBody CustomerLogin customerLogin) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int logout(@RequestParam("loginId") int loginId) {
        throw new RuntimeException("服务器繁忙");
    }
}
