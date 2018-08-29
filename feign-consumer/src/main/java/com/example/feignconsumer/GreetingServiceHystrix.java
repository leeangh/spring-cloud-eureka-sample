package com.example.feignconsumer;

import org.springframework.stereotype.Component;

@Component
public class GreetingServiceHystrix implements GreetingService {

    @Override
    public String greeting() {
        return "Eureka-service is not available";
    }

    @Override
    public String greeting(String name) {
        return greeting();
    }
}