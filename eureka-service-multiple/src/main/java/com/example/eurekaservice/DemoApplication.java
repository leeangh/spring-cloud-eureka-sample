package com.example.eurekaservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class DemoApplication {

    @RestController
    class ServiceInstanceRestController {

        @Value("${server.port}")
        String port;

        @RequestMapping("/greeting/{name}")
        public String greeting(@PathVariable String name) {
            return "Hello " + name + "! I'm service from port : " + port;
        }

        @RequestMapping("/greeting")
        public String greeting() {
            return "Greetings! I'm service from port : " + port;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
