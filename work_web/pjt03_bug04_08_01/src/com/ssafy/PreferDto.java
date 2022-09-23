package com.ssafy;

public class PreferDto {
	private String sido;
	private String gugun;
	private String dong;

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}




	@Override
	public String toString() {
		return "PreferDto [sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + "]";
	}
	
	
}
