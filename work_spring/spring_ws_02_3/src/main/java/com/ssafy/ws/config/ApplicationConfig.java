package com.ssafy.ws.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration // 환경설정 파일임을 명시
@ComponentScan(basePackages = {"com.ssafy.ws"}) // 해당 패키지 내의 빈 스캔하여 스프링 컨테이너에 등록
@EnableAspectJAutoProxy // AOP의 ProxyBeanFactory 생성
public class ApplicationConfig {
	// Annotation(@Component, @Service, @Repository 등등) 방식으로 생성할 수 없는 빈은 @Bean을 통해 선언한다.
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/ssafy_ws?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8");
		dataSource.setUsername("ssafy");
		dataSource.setPassword("ssafy");
		
		return dataSource;
	}
}
/*
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:context="http://www.springframework.org/schema/context"
xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

<context:component-scan base-package="com.ssafy.ws.model"></context:component-scan>

<!-- datasource bean 작성 -->
<bean id="dataSource"
	class="org.springframework.jdbc.datasource.SimpleDriverDataSource">
	<property name="driverClass" value="com.mysql.cj.jdbc.Driver"></property>
	<property name="url"
		value="jdbc:mysql://127.0.0.1:3306/ssafy_ws?serverTimezone=UTC&amp;useUniCode=yes&amp;characterEncoding=UTF-8"></property>
	<property name="username" value="ssafy"></property>
	<property name="password" value="ssafy"></property>
</bean>
</beans>
*/

