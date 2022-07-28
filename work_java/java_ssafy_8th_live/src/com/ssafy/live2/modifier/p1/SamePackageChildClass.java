package com.ssafy.live2.modifier.p1;

// TODO: Parent를 상속받고 Parent의 member들에 접근해보세요.
 public class SamePackageChildClass extends Parent{
	 
	 public void method() {
		 this.publicVar = 10;
		 this.protectVar = 10;
		 this.defaultVar = 10;
//		 this.privVar = 10; // 접근할 수 없음 The field Parent.privVar is not visible
//		 this.someVar = 10; // 걍 없음 someVar cannot be resolved or is not a field
	 }
    // END:
}
