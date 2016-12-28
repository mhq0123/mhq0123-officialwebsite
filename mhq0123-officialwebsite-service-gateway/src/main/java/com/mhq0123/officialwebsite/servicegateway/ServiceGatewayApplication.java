package com.mhq0123.officialwebsite.servicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/28.
 * desc:
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayApplication.class, args);
    }
}
