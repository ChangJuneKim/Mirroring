package com.ssafy.hw.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Pair {
	int a, b;

	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Pair [a=")
//			.append(a)
//			.append(", b=")
//			.append(b)
//			.append("]");
//		return builder.toString();
//	}

}



public class Main {
	
	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.valueOf(br.readLine());
		
		Pair[] ci = new Pair[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ci[i] = new Pair(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
		}

		int count = 1;
		// 최고 온도 기준으로 오름 차순으로 정렬한다.
		Arrays.sort(ci, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return Integer.compare(o1.b, o2.b);
			}
		});

		// 최고 온도가 제일 작은 것을 기준으로 한다.
		int r = ci[0].b;

		for (int i = 1; i < n; i++) {
			if (r < ci[i].a) { // 현재 물질의 최저 온도가 기준 최고온도보다 더 크면, 냉장고를 추가하며 기준을 변경한다.
				r = ci[i].b;
				count++;
			}
		}

		System.out.println(count);
	}
	

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}