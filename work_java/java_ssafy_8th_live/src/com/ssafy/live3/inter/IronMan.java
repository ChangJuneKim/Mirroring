// @@DELETE_FILE:
package com.ssafy.live3.inter;

public class IronMan implements Heroable {
    int weaponDamage = 100;

    @Override
    public int fire() {
        System.out.printf("적의 에너지 감소: " + weaponDamage);
        return weaponDamage;
    }

    @Override
    public void changeShape(boolean isHeroMode) {
        if (isHeroMode) {
        	System.out.println("장갑 장착");
        }
        else {
        	System.out.println("일반 토니스타크");
        }
    }

    @Override
    public void upgrade() {
        System.out.printf("성능 개선");
    }
}
