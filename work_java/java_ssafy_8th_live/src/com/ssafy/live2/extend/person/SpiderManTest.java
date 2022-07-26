// ##DELETE_FILE:
package com.ssafy.live2.extend.person;

public class SpiderManTest {

	@SuppressWarnings({ "deprecation", "unused" })
	public static void main(String[] args) {
		int i = 10;
		SpiderMan sman = new SpiderMan("피터파커", false);
		sman.eat();  // person
		sman.jump();  // person
		sman.fireWeb();  // spiderman
		sman.isSpider = true;
		sman.eat();  // person
		sman.jump();  // person -> 재정의 후에는 spiderman의 jump() 호출
		sman.fireWeb();  // spiderman
		sman.love();
		System.out.println(sman.toString());
	}
}

