package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");
			int lengthOfPassword = Integer.valueOf(br.readLine());

			ArrayList<String> originPassword = new ArrayList<>();

			// 원본 암호문 입력 완료
			String[] password = br.readLine().split(" ");
			for (int i = 0; i < lengthOfPassword; i++) {
				originPassword.add(password[i]);
			}

			int numOfCommand = Integer.valueOf(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				if (st.nextToken().equals("I")) {
					int x = Integer.valueOf(st.nextToken());
					int y = Integer.valueOf(st.nextToken());

					for (int i = 0; i < y; i++) {
						originPassword.add(x++, st.nextToken());
					}
				}

			}
			
			for (int i = 0; i < 10; i++) {
				sb.append(originPassword.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Solution().solution();
	}
}
