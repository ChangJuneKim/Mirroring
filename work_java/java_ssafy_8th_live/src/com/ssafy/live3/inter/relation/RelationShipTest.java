package com.ssafy.live3.inter.relation;


public class RelationShipTest {
    public static void main(String[] args) {
        Object [] objs = {new HandPhone(), new Camera(), new Phone(), new DigitalCamera()};
        
        // TODO: 충전 가능한 객체들을 충전하시오.
        for (Object object : objs) {
			if(object instanceof Chargeable) {
				Chargeable chargeable  = (Chargeable) object;
				chargeable.charge();
			}
		}
        // END:
    }

}
