package com.tech.microservice.service.feign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.tech.microservice.service.constant.ServiceConstant.SERVICE_PROVIDER;

@FeignClient(name= SERVICE_PROVIDER, fallback = ServiceFeignServiceFallback.class)
public interface ServiceFeignService {

    @RequestMapping("/service1")
    String service1();

    @RequestMapping(value = "/badservice", method = RequestMethod.GET)
    String badservice() ;

}
