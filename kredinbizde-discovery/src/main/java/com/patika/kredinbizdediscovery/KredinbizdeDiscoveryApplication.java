package com.patika.kredinbizdediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class KredinbizdeDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(KredinbizdeDiscoveryApplication.class, args);
	}

}
