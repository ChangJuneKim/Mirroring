package com.ssafy.greeting;

import java.lang.reflect.InvocationTargetException;

public interface MessageService {
	void sayHello() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
