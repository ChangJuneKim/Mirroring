package com.ssafy.live3.inter;

public class IronMan implements Heroable{

	int weaponDamage = 100;
	@Override
	public int fire() {
		System.out.println("적의 에너지 감소 : " + weaponDamage);
		return weaponDamage;
	}

	@Override
	public void changeShape(boolean isHeroMode) {
		// TODO Auto-generated method stub
		if(isHeroMode) {
			System.out.println("나는 아이언맨");
		} else {
			System.out.println("나는 토니 스타크");
		}
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		System.out.println("성능 개선");
	}
	
}
