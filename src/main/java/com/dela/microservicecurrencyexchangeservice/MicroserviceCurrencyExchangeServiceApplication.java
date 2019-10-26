package com.dela.microservicecurrencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//Same as @EnableDiscoveryClient when Eureka is on classpath
@EnableEurekaClient
public class MicroserviceCurrencyExchangeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCurrencyExchangeServiceApplication.class, args);
    }

}
