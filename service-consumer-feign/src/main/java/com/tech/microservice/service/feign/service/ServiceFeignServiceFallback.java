package com.tech.microservice.service.feign.service;


import org.springframework.stereotype.Component;

@Component
public class ServiceFeignServiceFallback implements ServiceFeignService{
    @Override
    public String service1() {
        return "service1 fallback";
    }

    @Override
    public String badservice() {
        return "badservice fallback";
    }
}
