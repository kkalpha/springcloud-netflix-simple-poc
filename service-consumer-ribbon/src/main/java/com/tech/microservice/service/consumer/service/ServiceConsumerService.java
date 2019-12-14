package com.tech.microservice.service.consumer.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceConsumerService {
    private final Logger logger = LoggerFactory.getLogger(ServiceConsumerService.class);
    @Autowired
    RestTemplate restTemplate;

    public String service1() throws Exception {
        logger.info("/service1");

        StringBuilder result = new StringBuilder();
        result.append(restTemplate.getForEntity("http://SERVICE-PROVIDER/service1", String.class).getBody());

        return result.toString();
    }

}
