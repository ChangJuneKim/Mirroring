package com.ssafy.rent.model.dto;

import java.util.Date;

public class EnvironmentInfo {
	private int no;
	private String name; // 업체명 
	private String date; // 지도점검일
	private String desc; // 점검사항
	private String addr; // 소재지주소
	
	public EnvironmentInfo() {
		super();
	}
	
	public EnvironmentInfo(int no, String name, String date, String desc, String addr) {
		super();
		this.no = no;
		this.name = name;
		this.date = date;
		this.desc = desc;
		this.addr = addr;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnvironmentInfo [no=").append(no).append(", name=").append(name).append(", date=").append(date)
				.append(", desc=").append(desc).append(", addr=").append(addr).append("]");
		return builder.toString();
	}
	
	
}
