// ##DELETE_FILE:
package com.ssafy.live2.poly;

import com.ssafy.live2.extend.person.Person;
import com.ssafy.live2.extend.person.SpiderMan;

public class PolySpiderTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		SpiderMan onlyOne = new SpiderMan("피터파커", true);

		// 다형성
		SpiderMan sman = onlyOne;
		Person person = onlyOne;
		Object obj = onlyOne;

		// 명시적 형 변환
		SpiderMan reSpider = (SpiderMan) obj;
		reSpider.fireWeb();

		// 뭐든지 담을 수 있는 만능의 주머니
		Object[] objs = new Object[4];
		objs[0] = sman;
		objs[1] = "Hello";
		objs[2] = objs;
		objs[3] = 1;  // 기본형이었는데.. ㅜㅜ --> Auto boxing

		SpiderMan fromObjArray = (SpiderMan) objs[0];
		fromObjArray.fireWeb();

		// 형 변환을 할 때에는 반드시 타입을 확인하고 하자!!
		if (objs[1] instanceof SpiderMan) {
			SpiderMan fromObjArray2 = (SpiderMan) objs[1];
			fromObjArray2.fireWeb();
		}

		for (Object o : objs) {
			System.out.println(o.getClass().getName());
		}

		System.out.println(sman);
		System.out.println(person);
	}
}

class Venom extends SpiderMan{}