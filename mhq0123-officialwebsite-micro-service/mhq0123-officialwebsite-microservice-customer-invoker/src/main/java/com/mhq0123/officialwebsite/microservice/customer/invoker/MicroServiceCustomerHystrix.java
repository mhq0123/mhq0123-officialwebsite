package com.mhq0123.officialwebsite.microservice.customer.invoker;

import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.Customer;
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
    public Customer selectCustomerById() {
        logger.info(this.getClass() + " is error, hold on...");
        return null;
    }
}
