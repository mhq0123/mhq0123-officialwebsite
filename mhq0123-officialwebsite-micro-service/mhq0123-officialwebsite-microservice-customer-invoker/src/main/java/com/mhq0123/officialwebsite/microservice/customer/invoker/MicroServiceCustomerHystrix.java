package com.mhq0123.officialwebsite.microservice.customer.invoker;

import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.account.CustomerAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
    public int accountInsert() {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public CustomerAccount accountSelectByUniqueField() {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountUpdateById() {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountFreezeById() {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountUnfreezeById() {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountCancelById() {
        throw new RuntimeException("服务器繁忙");
    }
}
