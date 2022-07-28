package com.ssafy.live2.extend.person;

public class SpiderMan extends Person {
	public boolean isSpider;
	public Spider spider = new Spider();

	public SpiderMan(String name, boolean isSpider){
		// this() 나 super() 가 올 수 있는데 아무것도 없으면 "super()가 생략되어있는것 <- 컴파일러가 기본으로 넣어준다"
		super(name);
		this.isSpider = isSpider;
	}
	
	public void fireWeb() {
		if (isSpider) {
			spider.fireWeb();
		} else {
			System.out.println("사람일때는 참자");
		}

	}

	// 오버라이딩
	@Override
	public void jump() {
		if (isSpider) {
			spider.jump();
		} else {
//			System.out.println("두 다리로 폴짝!!");
			super.jump();
		}
	}

	@Deprecated
	public void love() {
		System.out.println("메리제인 사랑해~");
	}

	@Override
	// super. <-- 조상의 멤버
	// this. <-- 나의 멤버
	public String toString() {
		return super.toString() + ", isSpider : " + isSpider;
	}

}
