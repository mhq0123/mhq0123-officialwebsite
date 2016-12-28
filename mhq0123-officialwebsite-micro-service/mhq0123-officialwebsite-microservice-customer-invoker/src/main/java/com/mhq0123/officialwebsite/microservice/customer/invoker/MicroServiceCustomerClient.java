package com.mhq0123.officialwebsite.microservice.customer.invoker;

import com.mhq0123.officialwebsite.microservice.customer.invoker.bean.Customer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/28.
 * desc:    接口定义
 */
@FeignClient(value = MicroServiceCustomerPath.SERVICE_ID, fallback = MicroServiceCustomerHystrix.class)
public interface MicroServiceCustomerClient {

    @GetMapping(MicroServiceCustomerPath.SELECT_CUSTOMER_BY_ID)
    Customer selectCustomerById();
}
