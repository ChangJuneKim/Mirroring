package com.ssafy.greeting.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ssafy.greeting.MessageService;

public class MessageProxy implements MessageService {

	private MessageService service; // Proxy 대상 (Target)
	private LogAspect aspect; // Proxy 대본 (Proxy)

	public MessageProxy(MessageService service, LogAspect logAspect) {
		this.service = service;
		this.aspect = logAspect;
	}

	@Override
	public void sayHello() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = aspect.getClass();

		Method before = null;
		Method after = null;

		for (Method m : clazz.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Aspect.class)) {
				Aspect annotation = m.getAnnotation(Aspect.class);

				boolean isSayHello = annotation.target().equals("sayHello()");
				boolean isBefore = annotation.timing().equals("before");
				boolean isAfter = annotation.timing().equals("after");

				if (isSayHello && isBefore) {
					before = m;
				} else if (isSayHello && isAfter) {
					after = m;
				}
			}
		}

		if (before != null) {
			before.invoke(aspect, null);
		}
		this.service.sayHello();
		if (after != null) {
			after.invoke(aspect, null);
		}

	}

}
