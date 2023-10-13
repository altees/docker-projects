package com.altess.AccountMS;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountMsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountMsApplication.class, args);
	}

}
