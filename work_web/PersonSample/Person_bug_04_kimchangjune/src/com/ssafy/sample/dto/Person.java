package com.ssafy.sample.dto;

public class Person {
	private String id;
	private String name;
	private String department_name;
	private int pay;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String id, String name, String department_name, int pay) {
		super();
		this.id = id;
		this.name = name;
		this.department_name = department_name;
		this.pay = pay;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

}
