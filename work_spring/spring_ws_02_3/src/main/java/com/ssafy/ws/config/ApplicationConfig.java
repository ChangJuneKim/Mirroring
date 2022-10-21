package com.ssafy.ws.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration  // 이 파일이 환경설정 파일임을 명시
@ComponentScan(basePackages = {"com.ssafy.ws"})  // 해당 패키지 내의 빈 스캔하여 스프링 컨테이너에 등록
@EnableAspectJAutoProxy  // AOP의 ProxyBeanFactory 생성
public class ApplicationConfig {
	
	// Annotation(@Component, @Service, @Repository 등등) 방식으로 생성할 수 없는 빈은 @Bean을 통해 선언한다.
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost:3306/ssafy_ws?serverTimezone=UTC");
		dataSource.setUsername("ssafy");
		dataSource.setPassword("ssafy");
		
		return dataSource;
	}
}

/*
	<!-- com.ssafy.ws.model 패키지를 스캔해서 빈을 등록한다. -->
	<context:component-scan base-package="com.ssafy.ws.model"></context:component-scan>
	
	<!-- Spring AOP의 ProxyFactoryBean을 자동으로 생성하는 태그 -->
	<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
	
	<!-- DataSource 빈 등록 -->
	<bean id="dataSource" class="org.springframework.jdbc.datasource.SimpleDriverDataSource">
		<property name="driverClass" value="com.mysql.cj.jdbc.Driver"></property>
		<property name="url" value="jdbc:mysql://localhost:3306/ssafy_ws?serverTimezone=UTC"></property>
		<property name="username" value="ssafy"></property>
		<property name="password" value="ssafy"></property>
	</bean>
*/