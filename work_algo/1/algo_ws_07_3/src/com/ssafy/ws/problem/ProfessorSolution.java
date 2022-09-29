package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProfessorSolution {
	int N;
	int[][] rooms;
	int max;
	int firstRoom;
	
	public boolean isValidCoords(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	public void solution() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		int TC = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			sb.append("#").append(testCase).append(" ");
			N = Integer.valueOf(br.readLine());
			
			max = -1;
			firstRoom = -1;
			rooms = new int[N][];

			for (int i = 0; i < N; i++) {
				rooms[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			}

			// solve
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					search(x, y);
				}
			}	
			sb.append(firstRoom).append(" ").append(max).append("\n");
			
		}
		System.out.println(sb);
	}

	private void search(int startX, int startY) {
		// TODO Auto-generated method stub
		int no = rooms[startX][startY]; // 출발점의 값

		int curX = startX;
		int curY = startY;

		int count = 1;
		boolean[][] isVisited = new boolean[N][N];
		isVisited[curX][curY] = true;

		// 상하좌우
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		
		for (int i = 0; i < 4; i++) {
			int testX = curX + dx[i];
			int testY = curY + dy[i];
			
			if (isValidCoords(testX, testY)) {
				if(isVisited[testX][testY] == false && rooms[testX][testY] == rooms[curX][curY] + 1) {
					curX = testX;
					curY = testY;
					
					count++;
					
					isVisited[curX][curY] = true;
					
					i = -1;
				}
			}
		}
		
		if(count > max) {
			firstRoom = no;
			max = count;
		} else if(count == max) {
			if(no < firstRoom) {
				firstRoom = no;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		new ProfessorSolution().solution();
	}
}
