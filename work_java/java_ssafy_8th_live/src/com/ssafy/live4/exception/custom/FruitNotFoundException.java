// @@DELETE_FILE:
package com.ssafy.live4.exception.custom;

@SuppressWarnings("serial")
public class FruitNotFoundException extends Exception {
	
	private String englishName;
	
    public FruitNotFoundException(String name) {
        super(name + "에 해당하는 과일은 없습니다.");
    }

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
}
