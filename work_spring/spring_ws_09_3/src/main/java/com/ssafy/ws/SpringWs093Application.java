package com.ssafy.ws;

import java.util.Arrays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.ws.interceptor.SessionInterceptor;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.ssafy"})
@EnableAspectJAutoProxy
@MapperScan(basePackages = { "com.ssafy.**.dao" })
public class SpringWs093Application implements WebMvcConfigurer{
	
	private SessionInterceptor sessionInterceptor;
	
	@Autowired
	public SpringWs093Application(SessionInterceptor sessionInterceptor) {
		this.sessionInterceptor = sessionInterceptor;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringWs093Application.class, args);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor).addPathPatterns(Arrays.asList("/regist"));
	}

}
