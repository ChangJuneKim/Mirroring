package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt")); // 백준 올릴 땐 주석처리 할 것
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int numOfSwitches = Integer.valueOf(in.readLine());
		
		st = new StringTokenizer(in.readLine(), " "); // 스위치 상태 입력받기
		
		// 스위치 입력받기
		int[] switches = new int[numOfSwitches];
//		int[] switches = new int[st.countTokens()];
		for (int i = 0; i < switches.length; i++) {
			switches[i] = Integer.valueOf(st.nextToken());
		}
		
		int numOfStudents = Integer.valueOf(in.readLine());
		
		int receivedNumber = 0;
		
		for (int i = 0; i < numOfStudents; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			boolean isMale = st.nextToken().equals("1");
		
			if(isMale) {	
				// 남자
				receivedNumber = Integer.valueOf(st.nextToken());
				
				// 남자일땐 receivedNumber의 배수를 바꿈
				for (int j = 0; j < switches.length; j++) {
					if((j + 1) % receivedNumber == 0) {
						if(switches[j] == 1) {
							switches[j] = 0;
						} else if(switches[j] == 0){
							switches[j] = 1;
						}
					}
				}
			
				
			} else if(!isMale) {
				// 여자
				receivedNumber = Integer.valueOf(st.nextToken()) - 1;
				
				int leftSideSwitch = receivedNumber - 1;  
				int rightSideSwitch = receivedNumber + 1; 
				
				// 1. 일단 받은 번호는 스왑해야한다
				if(switches[receivedNumber] == 0) {
					switches[receivedNumber] = 1;
				} else if(switches[receivedNumber] == 1) {
					switches[receivedNumber] = 0;
				}
				
				while(true) {
					// 스위치 배열 범위 안쪽일때
					if(0 <= leftSideSwitch && rightSideSwitch < switches.length) {
						// 양쪽 스위치가 다르면 break
						if(switches[leftSideSwitch] != switches[rightSideSwitch]) {						
							break;
						}
						
						// 2. 받은 번호의 양쪽을 한칸씩 이동하면서 스위치의 상태가 같으면 스왑을 한다.
						if(switches[leftSideSwitch] == switches[rightSideSwitch]) {
							if(switches[leftSideSwitch] == 0) {
								switches[leftSideSwitch] = 1;
								switches[rightSideSwitch] = 1;
								leftSideSwitch--;
								rightSideSwitch++;
							} else if(switches[leftSideSwitch] == 1){
								switches[leftSideSwitch] = 0;
								switches[rightSideSwitch] = 0;
								leftSideSwitch--;
								rightSideSwitch++;
							}
						}
					}else break;
				}		
			}
		}
		for (int i = 1; i <= switches.length; i++) {
			System.out.print(switches[i - 1] + " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}
	}
}
