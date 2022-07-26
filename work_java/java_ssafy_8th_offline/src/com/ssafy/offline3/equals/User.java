package com.ssafy.offline3.equals;

public class User extends Object {

	private String id;
	private String password;
	private String name;
	private String email;
	private Integer age;
	
	public User() {}

	public User(String id, String password, String name, String email, Integer age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
				+ "]";
	}
	
	// id 값이 같으면 User 객체가 같다고 판단하도록 equals 메서드를 재정의 하세요.
	public boolean equals(Object obj) {
		// null 체크는 JDK 버전에 따라 instanceof 동작이 다를 수 있으므로 예방 차원에서 체크
		// JDK 8 버전에서는 null 체크를 하지 않아도 정상 동작
		if (obj != null && obj instanceof User) {
			if (this.getId().equals(((User) obj).getId())) {
				return true;
			}
		}
		
		return false;
	}
	
}
