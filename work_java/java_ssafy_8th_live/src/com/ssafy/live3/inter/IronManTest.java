package com.ssafy.live3.inter;

public class IronManTest {

	public static void main(String[] args) {
		IronMan iMan = new IronMan();
		// 인터페이스도 하나의 타입 -> 다형성은 가능하다!!
		Object obj = iMan;
		Heroable heroable = iMan;
		Fightable fightable = iMan;
		Transformable transformable = iMan;

	}

}
