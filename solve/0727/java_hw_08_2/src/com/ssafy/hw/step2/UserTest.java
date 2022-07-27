package com.ssafy.hw.step2;

import java.util.Arrays;

public class UserTest {

	public static void main(String[] args) {
		User user1 = new User();
		user1.setId("user1");
		user1.setPassword("user1");
		user1.setName("김싸피");
		user1.setEmail("ssafy1@ssafy.com");
		user1.setAge(27);

		User user2 = new User("user2", "user2", "박싸피", "ssafy2@ssafy.com", 28);
		VipUser vuser = new VipUser("vip1", "vip1", "김싸피", "ssafy3@ssafy.com", 29, "Gold", 300);

		IUserManager um = UserManagerImpl.getInstance();
		IUserManager um2 = UserManagerImpl.getInstance();

		um.add(user1);
		um.add(user2);
		um.add(vuser);

		// ArrayList로 자료 구조를 바꾼 뒤 똑같이 동작하는지 테스트한다.
		System.out.println("황 포함 찾기");
		System.out.println(Arrays.toString(um.searchByName("황")));
		System.out.println();
		
		System.out.println("박 포함 찾기");
		System.out.println(Arrays.toString(um.searchByName("박")));
		System.out.println();
		
		System.out.println("모든 유저 리스트");
		System.out.println(Arrays.toString(um.getList()));
		System.out.println();
		
		System.out.println("일반 유저 리스트");
		System.out.println(Arrays.toString(um.getUsers()));
		System.out.println();
		
		System.out.println("VIP 유저 리스트");
		System.out.println(Arrays.toString(um.getVipUsers()));
		System.out.println();
		
		System.out.println("평균나이");
		System.out.println(um.getAgeAvg());
		System.out.println();
		
		System.out.println("싱글톤 체크");
		System.out.println(um.equals(um2));
		System.out.println();

	}

}
