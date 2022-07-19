package com.ssafy.live2.modifier.p1;

public class Parent {
	public int publicVar;
	protected int protectVar;
	int defaultVar;
	@SuppressWarnings("unused")
    private int privVar;
	
	public void useMember() {
		this.publicVar = 10;
		this.protectVar = 10;
		this.defaultVar = 10;
		this.privVar = 10;
	}
}
