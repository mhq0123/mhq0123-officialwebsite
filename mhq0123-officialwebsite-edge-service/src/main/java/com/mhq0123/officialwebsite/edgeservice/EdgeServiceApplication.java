package com.mhq0123.officialwebsite.edgeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/29.
 * desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.mhq0123") // TODO 扫描包
@ComponentScan("com.mhq0123,org.mhq0123") // TODO 要加入扫描路径
@ServletComponentScan("org.mhq0123") // TODO 自动扫描servlet和filter
public class EdgeServiceApplication {

    private final static Logger logger = LoggerFactory.getLogger(EdgeServiceApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(EdgeServiceApplication.class).web(true).run(args);
    }
}
