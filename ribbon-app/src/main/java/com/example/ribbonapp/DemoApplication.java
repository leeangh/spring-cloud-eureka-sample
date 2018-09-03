package com.example.ribbonapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	public class MyController {

		@Autowired
		private LoadBalancerClient loadBalancer;

		private RestTemplate restTemplate = new RestTemplate();

		@RequestMapping(value="/greeting/{name}", method = RequestMethod.GET)
		public String greeting(@PathVariable String name) {
			ServiceInstance instance = loadBalancer.choose("greeting-serive");
			URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));

			return restTemplate.getForObject(storesUri+"/greeting/"+name, String.class);
		}
	}
}
