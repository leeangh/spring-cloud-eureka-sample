package com.example.ribbonapp;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RibbonClient(name = "greeting-serive")
public interface GreetingService {

    @RequestMapping(value = "/greeting/{name}", headers = "accept=text/plain")
    String greeting(@PathVariable String name);
}
