package com.mhq0123.officialwebsite.edgeservice;

import com.mhq0123.officialwebsite.microservice.customer.invoker.MicroServiceCustomerClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/29.
 * desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
@ComponentScan("com.mhq0123.officialwebsite") // TODO 要加入扫描路径
public class EdgeServiceApplication {

    private final static Logger logger = LoggerFactory.getLogger(EdgeServiceApplication.class);

    @Autowired
    private MicroServiceCustomerClient microServiceCustomerClient;

    public static void main(String[] args) {
        new SpringApplicationBuilder(EdgeServiceApplication.class).web(true).run(args);
    }
}
