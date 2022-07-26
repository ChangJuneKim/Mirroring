package com.ssafy.offline2.readline;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadLine {
	
	public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("ArrayTest_30_input.txt"));  // 문제에서 주어진 Input 데이터 파일명 작성
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String readLine = in.readLine();
        System.out.println(readLine);
        
        int a = Integer.parseInt(readLine);
        
        int b = Integer.parseInt(in.readLine());
        
        String readLine2 = in.readLine();
        System.out.println(readLine2);
        
        String[] s = readLine2.split(" ");
        System.out.println(s[0]);
        char c = s[0].charAt(0);
        
        System.setIn(new FileInputStream("ArrayTest_31_input.txt"));
        in = new BufferedReader(new InputStreamReader(System.in));
        
        String a1 = in.readLine();
        int i1 = Integer.parseInt(a1);
        
        String[] s1 = in.readLine().split(" ");
        String s2 = s1[0];
        int a2 = Integer.parseInt(s2);
        
        String s3 = s1[1];
        int a3 = Integer.parseInt(s3);
        
        // 마지막 줄 정수 3개를 정수 변수 3개를 선언하여 각각 넣어보세요.
        System.out.println(in.readLine());
        
    }
}
