package com.ssafy.greeting.aop;

public class LogAspect {
	
	@Aspect(target = "sayHello()", timing = "before") // Pointcut
	public void logStart() {
		System.out.println("시작");
	}
	
	@Aspect(target = "sayHello()", timing = "after") // Pointcut
	public void logEnd() {
		System.out.println("끝");
	}
}
