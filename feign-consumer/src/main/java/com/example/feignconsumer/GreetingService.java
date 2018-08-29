package com.example.feignconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "eureka-service", fallback = GreetingServiceHystrix.class)
public interface GreetingService {

    @RequestMapping(value = "/greeting", headers = "accept=text/plain")
    String greeting();

    @RequestMapping(value = "/greeting/{name}", headers = "accept=text/plain")
    String greeting(@PathVariable String name);
}
