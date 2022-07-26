// @@DELETE_FILE:
package com.ssafy.live3.inter;

public class IronManTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		IronMan iman = new IronMan();
		Object obj = iman;
		// 인터페이스도 하나의 타입 -> 다형성은 가능하다!!
		Transformable tf = iman;
		Heroable hero = iman;
		Fightable fight = iman;
	}
}