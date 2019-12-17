package com.tech.microservice.service.provider.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ServiceProviderController {

    private final Logger logger = LoggerFactory.getLogger(ServiceProviderController.class);

    @RequestMapping(value = "/service1", method = RequestMethod.GET)
    public String service1() throws Exception {
        logger.info("/service1");
        return "service1 by service provider";
    }

    @RequestMapping(value = "/badservice", method = RequestMethod.GET)
    public String badservice() throws Exception {
        logger.info("/badservice");
        // 测试超时触发断路器
		int sleepTime = new Random().nextInt(3000);
		logger.info("sleepTime:" + sleepTime);
		Thread.sleep(sleepTime);
        return "service (bad service) by service provider";
    }

}
