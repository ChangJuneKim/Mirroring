package com.ssafy.offline3.equals;

public class User {

	private String id;
	private String password;
	private String name;
	private String email;
	private int age;

	public User() {
	}

	public User(String id, String password, String name, String email, int age) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true; // 자기 자신과 비교하면 true

		if (obj instanceof User) { // 비교대상이 null이 아니거나, User일때만
			User casted = (User) obj;
			return id == (casted.id);
		}
		return false;
	}

}