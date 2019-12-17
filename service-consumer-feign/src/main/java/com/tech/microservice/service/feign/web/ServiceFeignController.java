package com.tech.microservice.service.feign.web;

import com.tech.microservice.service.feign.service.ServiceFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceFeignController {

    private final Logger logger = LoggerFactory.getLogger(ServiceFeignController.class);

    @Autowired
    ServiceFeignService serviceFeignService;

    @GetMapping(value = "/service1")
    public String service1() throws Exception {
        logger.info("/service1");
        return serviceFeignService.service1();
    }
    @GetMapping(value = "/badservice")
    public String badservice() throws Exception {
        logger.info("/badservice");
        return serviceFeignService.badservice();
    }
}
