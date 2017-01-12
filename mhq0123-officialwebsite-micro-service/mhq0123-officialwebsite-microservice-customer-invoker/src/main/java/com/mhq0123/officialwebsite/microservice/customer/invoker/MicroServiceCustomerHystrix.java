package com.mhq0123.officialwebsite.microservice.customer.invoker;

import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
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
public class MicroServiceCustomerHystrix implements MicroServiceCustomerClient {

    private final static Logger logger = LoggerFactory.getLogger(MicroServiceCustomerHystrix.class);

    @Override
    public int accountInsert(@RequestBody CustomerAccount insertBean) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public CustomerAccount accountSelectById(@RequestParam("accountId") int accountId) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public CustomerAccount accountSelectByName(@RequestParam("accountName") String accountName) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public CustomerAccount accountSelectByEmail(@RequestParam("email") String email) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountUpdateById(@RequestBody CustomerAccount updateBean) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountFreezeById(@RequestParam("accountId") int accountId) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountUnfreezeById(@RequestParam("accountId") int accountId) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountCancelById(@RequestParam("accountId") int accountId) {
        throw new RuntimeException("服务器繁忙");
    }
}
