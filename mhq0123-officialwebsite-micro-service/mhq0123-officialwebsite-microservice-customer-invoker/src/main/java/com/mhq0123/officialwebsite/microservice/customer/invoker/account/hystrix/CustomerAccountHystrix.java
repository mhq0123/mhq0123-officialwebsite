package com.mhq0123.officialwebsite.microservice.customer.invoker.account.hystrix;

import com.mhq0123.officialwebsite.microservice.customer.invoker.account.CustomerAccountClient;
import com.mhq0123.officialwebsite.microservice.customer.invoker.account.bean.CustomerAccount;
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
public class CustomerAccountHystrix implements CustomerAccountClient {

    private final static Logger logger = LoggerFactory.getLogger(CustomerAccountHystrix.class);

    @Override
    public int insert(@RequestBody CustomerAccount insertBean) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public CustomerAccount selectById(@RequestParam("accountId") int accountId) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int updateByName(@RequestBody CustomerAccount updateBean) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public CustomerAccount selectByName(@RequestParam("accountName") String accountName) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public CustomerAccount selectByEmail(@RequestParam("mapper") String email) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int updateById(@RequestBody CustomerAccount updateBean) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int freezeById(@RequestParam("accountId") int accountId) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int unfreezeById(@RequestParam("accountId") int accountId) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int cancelById(@RequestParam("accountId") int accountId) {
        throw new RuntimeException("服务器繁忙");
    }
}
