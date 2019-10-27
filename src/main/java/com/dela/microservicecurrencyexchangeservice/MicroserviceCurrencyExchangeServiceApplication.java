package com.dela.microservicecurrencyexchangeservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//Same as @EnableDiscoveryClient when Eureka is on classpath
@EnableEurekaClient
public class MicroserviceCurrencyExchangeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCurrencyExchangeServiceApplication.class, args);
    }

//    for sleuth
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
