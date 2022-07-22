package com.ssafy.offline3.modifier2;

import com.ssafy.offline3.modifier.Parent;

public class AnotherChild extends Parent{
	
	int data2 = data; // data가 Parent의 data인데 protected 이기 때문에 다른 패키지에서도 사용이 가능하다.
}
