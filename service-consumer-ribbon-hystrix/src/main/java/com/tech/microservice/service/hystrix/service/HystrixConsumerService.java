package com.tech.microservice.service.hystrix.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixConsumerService {
    private final Logger logger = LoggerFactory.getLogger(HystrixConsumerService.class);
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "badServiceFallback", commandKey = "badServiceKey")
    public String doBadService() throws Exception {
        long start = System.currentTimeMillis();
        logger.info("/badservice {}",start);

        StringBuilder result = new StringBuilder();
        result.append(restTemplate.getForEntity("http://SERVICE-PROVIDER/badservice", String.class).getBody());

        long end = System.currentTimeMillis();
        logger.info("Spend time : " + (end - start) );

        return result.toString();
    }
    public String badServiceFallback() {
        return "error when calling badservice";
    }
}
