package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) throws ApplicationException {
		// 테스트 코드 작성
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		System.out.println("****1. GeneralUser");
		GeneralUser generalUser = applicationContext.getBean("generalUser", GeneralUser.class);
		generalUser.useApp();
		
		System.out.println("****2. AdminUser");
		AdminUser adminUser = applicationContext.getBean(AdminUser.class);
		adminUser.useApp();
	}

}
