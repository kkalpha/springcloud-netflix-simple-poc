package com.tech.microservice.service.hystrix;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardApplication {

	/*
	1, opem http://localhost:7102/hystrix vive monitoring report
	2, input http://localhost:7101/hystrix.stream as source
	3, execut a batch requests
		for i in {1..50}
		do
		curl http://localhost:7101/service &
		done
	 */

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}

}
