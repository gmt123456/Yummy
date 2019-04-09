package com.gaomt.yummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class YummyApplication {

	public static void main(String[] args) {
		SpringApplication.run(YummyApplication.class, args);
	}

}
