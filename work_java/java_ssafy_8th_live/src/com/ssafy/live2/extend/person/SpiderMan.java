// ##DELETE_FILE:
package com.ssafy.live2.extend.person;

public class SpiderMan extends Person {
	boolean isSpider;
	Spider spider = new Spider();
	
	public SpiderMan() {}
	
	public SpiderMan(String name, boolean isSpider) {
		// this() or super() 가 올 수 있는데 아무것도 없으면 누가 생략??
		super(name);
		this.isSpider = isSpider;
	}

	public void fireWeb() {
		
		if (isSpider) {
			// null pointer ==> null.xx
			spider.fireWeb();
		}
		else {
			System.out.println("사람일 때는 참자!!");
		}
	}
	
	// 자식이 코드를 개선하면 자동적으로 사용하는 곳에서는 개선된 코드가 동작하다니...
	@Override
	public void jump() {
		
		if (isSpider) {
			spider.jump();
		}
		else {
			System.out.println("두 다리로 폴짝!!");  // 이 시국에 코드 중복이라니...
		}
	}
	
	@Deprecated
	public void love() {
		System.out.println("메리제인 사랑해!!");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", isSpider: " + isSpider;
	}
	
}