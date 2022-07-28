package com.ssafy.live2.extend.person;

public class SpiderManTest {

	public static void main(String[] args) {
		// static이 아닌 녀석들은 메모리에 없기때문에 객체를 통해서 접근해야 한다.
		// static메서드들은 객체를 만들지 않고도 불러올 수 있다.
		// 메인 메서드도 static이기 때문에 JVM에서 불러와서 main을 실행 시킨다.
		
		SpiderMan peter = new SpiderMan("피터파커", false);
		peter.eat(); // person
		peter.jump(); // person
		peter.fireWeb(); // spiderman
		
		peter.isSpider = true;
		
		peter.eat(); // person
		peter.jump(); // person
		peter.fireWeb(); // spiderman
		peter.love();
		
		System.out.println(peter.toString());
	}

}
