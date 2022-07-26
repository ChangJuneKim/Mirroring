package com.ssafy.live3.abs;


public class VehicleTest {

    public static void main(String[] args) {
        // @@TODOBLOCK: DieselSUV와 ElectricCar를 각각 한대씩 관리하는배열을 만들고 사용해보자.
        Vehicle[] vehicles = { new DieselSUV(), new ElectricCar() };
        
        for (Vehicle v : vehicles) {
          v.addFuel();
          v.reportPosition();
        }
        
        // 추상 클래스는 객체를 생성할 수 없다.
        // Vehicle v = new Vehicle();
        Vehicle v = new DieselSUV();  // 하지만 다형성은 당연히 OK
        // @@END:
      }

}
