package com.ssafy.offline5.stream;

public class Person {
	
	private String name;
	private int age;
	private String region;
	
	public Person(String name, int age, String region) {
		this.name = name;
		this.age = age;
		this.region = region;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj != null && obj instanceof Person) {
			Person p = (Person) obj;
			if (this.name.equals(p.name)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(name);
		builder.append(" : ");
		builder.append(age);
		builder.append(" : ");
		builder.append(region);
		builder.append("]");
		return builder.toString();
	}

}
