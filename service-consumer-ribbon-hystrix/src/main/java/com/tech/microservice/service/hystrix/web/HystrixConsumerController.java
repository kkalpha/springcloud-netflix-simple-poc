package com.tech.microservice.service.hystrix.web;

import com.tech.microservice.service.hystrix.service.HystrixConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixConsumerController {

    private final Logger logger = LoggerFactory.getLogger(HystrixConsumerController.class);

    @Autowired
    HystrixConsumerService hystrixConsumerService;

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public String service1() throws Exception {
        logger.info("/service");
        return hystrixConsumerService.doBadService();
    }

}
