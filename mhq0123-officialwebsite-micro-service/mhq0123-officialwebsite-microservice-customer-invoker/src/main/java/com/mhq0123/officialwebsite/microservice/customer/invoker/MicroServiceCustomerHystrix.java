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
    public int accountInsert(CustomerAccount insertBean) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public CustomerAccount accountSelectByUniqueField(MicroServiceCustomerDictionary.EnumAccountUniqueField accountUniqueField, String fieldValue) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountUpdateById(CustomerAccount updateBean) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountFreezeById(String accountId) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountUnfreezeById(String accountId) {
        throw new RuntimeException("服务器繁忙");
    }

    @Override
    public int accountCancelById(String accountId) {
        throw new RuntimeException("服务器繁忙");
    }
}
