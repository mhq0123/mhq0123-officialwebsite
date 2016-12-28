package com.mhq0123.officialwebsite.webclient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project: mhq0123-officialwebsite
 * author:  mhq0123
 * date:    2016/12/21.
 * desc:
 */
@SpringBootApplication
public class WebClientApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(WebClientApplication.class).web(true).run(args);
    }
}
