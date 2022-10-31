package com.ssafy.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ssafy.ws"})
@Configuration
@EnableAspectJAutoProxy
@MapperScan(basePackages = { "com.ssafy.ws.**.mappers" })
public class SpringWs093Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWs093Application.class, args);
	}

}
