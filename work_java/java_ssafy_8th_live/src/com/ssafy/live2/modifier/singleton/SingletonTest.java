package com.ssafy.live2.modifier.singleton;

class SingletonClass{
	// @@TODOBLOCK:SingletonClass에 Singleton Design Pattern을 적용하시오.
	private static SingletonClass instance;
	
	private SingletonClass() {}

	public static SingletonClass getInstance() {
		if (instance == null) {
			instance = new SingletonClass();
		}
		return instance;
	}
	
	// @@END:
	public void sayHello() {
		System.out.println("Hello");
	}

}

public class SingletonTest {
	
	public static void main(String[] args) {
		// @@TODOBLOCK:SingletonClass를 사용해보세요.  
		SingletonClass sc1 = SingletonClass.getInstance();
		SingletonClass sc2 = SingletonClass.getInstance();

		System.out.printf("두 객체는 같은가? %b%n", sc1==sc2);
		sc1.sayHello();
		// @@END:
	}
}
