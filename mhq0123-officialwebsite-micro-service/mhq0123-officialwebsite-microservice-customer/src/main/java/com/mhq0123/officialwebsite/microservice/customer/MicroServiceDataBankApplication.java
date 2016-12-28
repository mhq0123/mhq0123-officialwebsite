package com.mhq0123.officialwebsite.microservice.customer;

import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerPath;
import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/29.
 * desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class MicroServiceDataBankApplication {

    private final static Logger logger = LoggerFactory.getLogger(MicroServiceDataBankApplication.class);

    @GetMapping(MicroServiceCustomerPath.SELECT_CUSTOMER_BY_ID)
    public Customer selectUserByUserId() {
        Customer customer = new Customer();


        return customer;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceDataBankApplication.class, args);
    }
}
