package com.ssafy.hw.step2;

public class UserTest {

	public static void main(String[] args) {
		User user1 = new User();
		user1.setId("user1");
		user1.setPassword("user1");
		user1.setName("김싸피");
		user1.setEmail("ssafy1@ssafy.com");
		user1.setAge(27);

		User user2 = new User("user2", "user2", "박싸피", "ssafy2@ssafy.com", 28);
		VipUser vuser = new VipUser("vip1", "vip1", "김싸피" , "ssafy3@ssafy.com", 29, "Gold", 300);
		
//		UserManager um = new UserManager();
//		UserManager um1 = UserManager.getInstance();
//		UserManager um2= UserManager.getInstance();
//		System.out.println(um1 == um2);
		UserManager um = UserManager.getInstance();
		
		um.add(user1);
		um.add(user2);
		um.add(vuser);
	
		// "김" 이라는 단어를 이름에 포함하는 사용자 검색 결과 toString 으로 출력
		System.out.println("------------------------- \"김\" 포함 사용자 출력  -------------------------");
		for(User kimUser : um.searchByName("김")) {
			System.out.println(kimUser);
		}
		System.out.println();
		
		// 일반 사용자 리스트만 가져와서 toString 으로 출력
		System.out.println("------------------------- 일반 사용자 출력  -------------------------");
		for (User normalUser : um.getUsers()) {
			System.out.println(normalUser);
		}
		System.out.println();
		
		// 사용자들의 평균 나이 출력
		System.out.println("------------------------- 사용자 평균 나이  -------------------------");
		System.out.println(um.getAgeAvg());
		
	}

}
