package com.spring.hys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) //关闭自动配置
@EnableConfigurationProperties
@ComponentScan("com.spring.hys")
public class HysApplication {

	public static void main(String[] args) {
		SpringApplication.run(HysApplication.class, args);
	}

}
