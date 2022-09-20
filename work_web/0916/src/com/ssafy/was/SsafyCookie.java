package com.ssafy.was;

public class SsafyCookie {
	// 쿠키의 이름과 값
	private String name;
	private String value;
	
	// 쿠키의 유효기간 (초 단위)
	private int maxAge = -1;
	
	// 쿠키를 전송할 서버의 도메인
	private String domain;
	
	// 쿠키를 사용할 경로
	private String path;// (/ 는 전체 경로에서 사용)

	public SsafyCookie(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge * 1000; // 밀리초를 초로 변환
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
