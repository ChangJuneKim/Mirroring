package com.ssafy.ws01.step03;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 1;
		  for(int i=0; i<5; i++) {
	            for(int j=0; j<i; j++) {
	                System.out.print("\t");
	            }
	            for(; k<5-i; k++) {
	                System.out.print(k + "\t");
	            }
	            System.out.println();
	        }
	}

}
