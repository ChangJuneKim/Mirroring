package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	int N;
	StringBuilder sb = new StringBuilder("");
	
	public boolean isPrime(int n) {
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
          if (n % i == 0) {
              return false;
          }
        }
        return true;
    }
	
	public void recursive(int start, int cur) {
		if (cur == N) {
			// 끝 , 출력
			sb.append(start + "\n");
		}
		
		start = start * 10;
		
		for (int i = start; i < start + 10; i++) {
			if(isPrime(i)) {
				recursive(i , cur + 1);
			}
		}
	}
	
	public void solution() throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		
		recursive(2, 1); //2부터 1자리 수
		recursive(3, 1);
		recursive(5, 1);
		recursive(7, 1);
		
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().solution();
	}
}
