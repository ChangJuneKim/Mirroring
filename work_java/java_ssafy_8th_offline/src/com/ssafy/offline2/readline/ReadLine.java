package com.ssafy.offline2.readline;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReadLine {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test30_input.txt")); // 문제에서 주어진 input "데이터 파일명"을 읽어옴
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String readLine = in.readLine(); // 한줄 읽어오기
		
		int a = Integer.parseInt(readLine);
		
		int readLine2 = Integer.parseInt(in.readLine());
		String readLine3 = in.readLine();
		
		String[] split = readLine3.split(" ");
		
		char c = split[0].charAt(0);
		
		System.setIn(new FileInputStream("ArrayTest_31_input.txt"));
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(in.readLine());
		
		String[] s1 = in.readLine().split(" ");
		String s2 = s1[0];
		int a2 = Integer.parseInt(s2);
		
		String s3 = s1[1];
		int a3 = Integer.parseInt(s3);
		
		
		
		String[] split2 = in.readLine().split(" ");
		for(int i = 0; i < split2.length; i++) {
			System.out.println(Integer.parseInt(split2[i]));
		}
	}

}
