package com.tech.microservice.service.consumer.web;

import com.tech.microservice.service.consumer.service.ServiceConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceConsumerController {

    private final Logger logger = LoggerFactory.getLogger(ServiceConsumerController.class);

    @Autowired
    ServiceConsumerService serviceConsumerService;

    @RequestMapping(value = "/service1", method = RequestMethod.GET)
    public String service1() throws Exception {
        logger.info("/service1");
        return serviceConsumerService.service1();
    }

}
