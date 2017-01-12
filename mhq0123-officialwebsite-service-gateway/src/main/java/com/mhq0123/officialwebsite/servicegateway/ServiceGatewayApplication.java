package com.mhq0123.officialwebsite.servicegateway;

import org.mhq0123.springleaf.core.adapter.CorsConfigurerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/28.
 * desc:
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@Import(CorsConfigurerAdapter.class) // TODO 跨域支持
public class ServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayApplication.class, args);
    }
}
