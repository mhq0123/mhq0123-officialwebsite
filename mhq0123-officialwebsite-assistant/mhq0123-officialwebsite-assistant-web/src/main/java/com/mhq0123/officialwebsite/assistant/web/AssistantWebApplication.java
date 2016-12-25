package com.mhq0123.officialwebsite.assistant.web;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * project: officialwebsite
 * author:  mhq0123
 * date:    2016/12/25.
 * desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Controller
public class AssistantWebApplication {

    private final static Logger logger = LoggerFactory.getLogger(AssistantWebApplication.class);

//    @Autowired
//    private AssistantServiceClient assistantServiceClient;

    @GetMapping("index")
    public String index(ModelMap modelMap) {
        logger.info(">>>>>>>>>>>>>>>modelMap{}", JSONObject.toJSONString(modelMap, true));

//        modelMap.addAttribute("user", assistantServiceClient.selectUserByUserId());

        return "index";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(AssistantWebApplication.class).web(true).run(args);
    }
}
