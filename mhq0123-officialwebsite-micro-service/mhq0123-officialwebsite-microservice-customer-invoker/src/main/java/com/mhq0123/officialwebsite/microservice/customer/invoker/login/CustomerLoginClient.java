package com.mhq0123.officialwebsite.microservice.customer.invoker.login;

import com.mhq0123.officialwebsite.microservice.customer.invoker.CustomerInvokerConstant;
import com.mhq0123.officialwebsite.microservice.customer.invoker.login.bean.CustomerLogin;
import com.mhq0123.officialwebsite.microservice.customer.invoker.login.hystrix.CustomerLoginHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/28.
 * desc:    接口定义 这里必须主动申明方法名 TODO 不能写成GetMapping
 */
@FeignClient(value = CustomerInvokerConstant.SERVICE_ID, fallback = CustomerLoginHystrix.class)
public interface CustomerLoginClient {

    /**
     * 登陆
     * @param customerLogin
     * @return
     */
    @RequestMapping(value = CustomerLoginPath.LOGIN, method = RequestMethod.POST)
    int login(@RequestBody CustomerLogin customerLogin);

    /**
     * 登出
     * @param loginId
     * @return
     */
    @RequestMapping(value = CustomerLoginPath.LOGOUT, method = RequestMethod.POST)
    int logout(@RequestParam("loginId") int loginId);
}
