package com.tech.microservice.service.provider.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {

    private final Logger logger = LoggerFactory.getLogger(ServiceProviderController.class);

    @RequestMapping(value = "/service1", method = RequestMethod.GET)
    public String service1() throws Exception {
        logger.info("/service1");
        return "service by service provider";
    }

}
