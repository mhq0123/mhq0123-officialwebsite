package com.mhq0123.officialwebsite.assistant.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/25.
 * desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AssistantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssistantServiceApplication.class, args);
    }
}
