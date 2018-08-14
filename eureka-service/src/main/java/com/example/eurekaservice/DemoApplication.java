package com.example.eurekaservice;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
@RestController
public class DemoApplication {

	@RestController
	class ServiceInstanceRestController {

		@Autowired
		private EurekaClient eurekaClient;

		@RequestMapping("/service-instances/{applicationName}")
		public Applications serviceInstancesByApplicationName(
				@PathVariable String applicationName) {
			return this.eurekaClient.getApplications(applicationName);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
