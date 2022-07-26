// ##DELETE_FILE:
package com.ssafy.live2.extend.person;

public class SpiderMan2Test {

	public static void main(String[] args) {
		SpiderMan2 sman = new SpiderMan2();
		System.out.println("거미 모드로 변신:");
		sman.isSpider=true;
		sman.jump();
		System.out.println("사람 모드로 변신:");
		sman.isSpider=false;
		sman.jump();
		System.out.println(sman);
	}
}