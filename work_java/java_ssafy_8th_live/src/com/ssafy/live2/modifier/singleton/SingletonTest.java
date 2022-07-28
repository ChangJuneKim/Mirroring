package com.ssafy.live2.modifier.singleton;

class SingletonClass {
	// TODO:SingletonClass에 Singleton Design Pattern을 적용하시오.
	
	// 0. stateless한 클래스 - 상태를 가지지 않고 기능만 있는 클래스
	
	// 2. 여기서 private하게 객체를 생성한다
	private static SingletonClass sc = new SingletonClass();
	
	// 1
	public SingletonClass() {
	}
	
	// 3 static으로 메모리에 미리 올린다 getter 메소드를
	public static SingletonClass getSingleTonClass() {
		return sc;
	}

	// END:
	public void sayHello() {
		System.out.println("Hello");
	}

}

public class SingletonTest {
	public static void main(String[] args) {
		// TODO:SingletonClass를 사용해보세요.
		// 1. 우리는 객체가 하나만 있으면 좋겠다! 객체를 외부에서 생성 못하게 하자! 생성자를 private
//		SingletonClass sc = new SingletonClass();
//		sc.sayHello();
//
//		SingletonClass sc2 = new SingletonClass();
//		sc2.sayHello();
		
		// 4. getter로 객체를 불러와서 쓰자~
		SingletonClass sc1 = SingletonClass.getSingleTonClass();
		sc1.sayHello();
		
		SingletonClass sc2 = SingletonClass.getSingleTonClass();
		sc2.sayHello();
		
		System.out.println(sc1 == sc2); // 같은 객체를 가리킨다

		// END:
	}
}
