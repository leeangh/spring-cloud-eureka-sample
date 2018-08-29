package com.example.feignconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

    @RestController
    public class FeignConsumerController {
        @Autowired
        GreetingService greetingService;

        @RequestMapping(value="/greeting", method = RequestMethod.GET)
        public String greeting() {
            return greetingService.greeting();
        }

        @RequestMapping(value="/greeting/{name}", method = RequestMethod.GET)
        public String greeting(@PathVariable String name) {
            return greetingService.greeting(name);
        }
    }
}
