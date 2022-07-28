package com.ssafy.live2.poly;

import java.util.Arrays;
import java.util.Iterator;

import com.ssafy.live2.extend.person.Person;
import com.ssafy.live2.extend.person.SpiderMan;

public class PolySpiderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiderMan sman = new SpiderMan("피터파커", true);
		
		// 다형성
		SpiderMan sman2 = sman;
		Person person = sman; // 어차피 조상의 것을 자식이 가지고 있기때문에 형 변환을 해줄 필요없다~
		Object obj = person;
		
		// 명시적 형 변환
		SpiderMan reSpider = (SpiderMan)obj; // 오브젝트는 거미줄을 못쏘는데? (메모리에 있으니까 걱정마 ㅋ 명시적 형변환을 해준다)
		reSpider.fireWeb();
		
		//뭐든지 담을 수 있는 만능 주머니
		Object [] objs = new Object[4];
		
		objs[0] = sman;
		objs[1] = "Hello";
		objs[2] = objs;
		objs[3] = 1; // 기본형은 못들어 갈 줄 알았는데 Wrapper 객체로 autoboxing 되어 들어간다
		
		SpiderMan fromObjArray = (SpiderMan)objs[0];
		fromObjArray.fireWeb();
		
		// 2 형변환을 할 때에는 반드시 타입을 확인하고 하자!
		if(objs[1] instanceof SpiderMan) {
			SpiderMan fromObjArray2 = (SpiderMan)objs[1]; // 1 String이 거미줄을 쏠 수 있을까..? 컴파일 에러는 나지않지만 런타임 에러가 난다
			fromObjArray2.fireWeb();
		}
	
		for (Object o : objs) {
			System.out.println(o);
		}
		
		System.out.println(sman2);
		System.out.println(person);
		
	}

}
