package com.ssafy.ws.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProfessorSolution {
	private static int[] kyuCard; // 규영이가 뽑은 카드
	private static int[] remainCard; // 규영이가 뽑고 남은 카드
	private static int[] inCard; // 남은 카드로 인영이가 뽑은 카드
	private static boolean[] isSelected; // 인영이의 카드 사용유무
	private static int kyuWin;
	private static int kyuLose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");

		int TC = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			sb.append("#").append(testCase).append(" ");

			kyuWin = 0;
			kyuLose = 0;

			remainCard = new int[9];
			inCard = new int[9];
			isSelected = new boolean[9];

			boolean[] deck = new boolean[18 + 1];
			String[] split = br.readLine().split(" ");
			kyuCard = new int[9]; // 규영이가 가지고 있는 카드
			for (int i = 0; i < 9; i++) {
				kyuCard[i] = Integer.valueOf(split[i]); // 규영이가 뽑은 카드 저장
				int pickNumber = kyuCard[i]; // 규영이가 뽑은 카드 번호
				deck[pickNumber] = true; // 뽑은 카드 표시
			}

			int decIndex = 0;
			for (int i = 0; i < 9; i++) {
				while (decIndex < 18) {
					decIndex++;
					if (deck[decIndex] == false) { // 뽑지 않은 카드면
						deck[decIndex] = true; // 뽑고
						remainCard[i] = decIndex; // 인영이가 가져간다.
						break;
					}
				}
			}

			perm(0);

			sb.append(kyuWin + " " + kyuLose + "\n");

		}
		System.out.println(sb);
	}

	// cnt : 직전까지 뽑은 순열에 포함된 카드의 개수, cnt + 1 번째 해당하는 카드 뽑기
	private static void perm(int cnt) {

		// 기저 부분 (종료 조건)
		if (cnt == 9) {
			int kyuScore = 0;
			int inScore = 0;

			for (int i = 0; i < 9; i++) {
				int kyu = kyuCard[i];
				int in = inCard[i];

				if (kyu > in) {
					kyuScore += kyu + in;
				} else if (kyu < in) {
					inScore += kyu + in;
				}
			}

			if (kyuScore > inScore) {
				kyuWin++;
			} else if (kyuScore < inScore){
				kyuLose++;
			}
		}

		// 유도 부분
		// 가능한 모든 카드에 대해 시도
		for (int i = 0; i < 9; i++) {
			// 시도하는 카드가 선택되었는지 판단
			if (isSelected[i]) {
				continue;
			}

			// 선택되지 않았다면 카드를 사용
			inCard[cnt] = remainCard[i];
			isSelected[i] = true;
			// 다음 카드 뽑으러 가기
			perm(cnt + 1);
			// 사용했던 카드 되돌리기
			isSelected[i] = false;
		}
	}
}
