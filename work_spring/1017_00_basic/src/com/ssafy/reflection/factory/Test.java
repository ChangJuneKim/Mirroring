package com.ssafy.reflection.factory;

public class Test {
	public static void main(String[] args) {
		UserDao userDao = new MyDao();
		UserService service = new UserService(userDao);
		
		User user = new User(1, 29, "김창준");
		service.add(user);
		User findUser = service.get(1);
		
		System.out.println(findUser);
	}
}
