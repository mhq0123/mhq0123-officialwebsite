package com.mhq0123.officialwebsite.microservice.customer;

import org.mhq0123.springleaf.core.configuration.DruidConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/29.
 * desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement // 事务驱动
@MapperScan("com.mhq0123") // 扫描mapper的包
@ComponentScan("com.mhq0123,org.mhq0123") // 扫描组件
@Import(DruidConfiguration.class) // 开启druid监控
public class MicroServiceCustomerApplication {

    private final static Logger logger = LoggerFactory.getLogger(MicroServiceCustomerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCustomerApplication.class, args);
    }
}
