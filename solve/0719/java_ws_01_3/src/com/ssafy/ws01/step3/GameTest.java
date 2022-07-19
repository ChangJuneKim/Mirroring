package com.ssafy.ws01.step3;

import java.util.Scanner;

// 내 풀이

//import java.util.Scanner;
//
//public class GameTest {
//	public static void main(String[] args) {
//		// 메인 메소드
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
//		System.out.println("1. 5판 3승");
//		System.out.println("2. 3판 2승");
//		System.out.println("3. 1판 1승");
//
//		System.out.print("번호를 입력하세요. ");
//		
//		int gameRoundInput = sc.nextInt(); // 1 ~ 3 \
//		int gameCount = 0; // 몇 판 할지
//		int userWinCount = 0; // 유저 승리 수
//		int comWinCount = 0; // 컴퓨터 승리 수
//		
//
//		// 게임 판수 정하기
//		switch (gameRoundInput) {
//		case 1:
//			gameCount = 5; // 5판
//			break;
//		case 2:
//			gameCount = 3; // 3판
//			break;
//		case 3:
//			gameCount = 1; // 1판
//			break;
//		default:
//			System.out.print("1~3 사이의 숫자만 입력해주세요.");
//			break;
//		}
//		int goalCount = (int) (gameCount / 2 + 1); // 목표로 할 승리 수 (5판 "3승",3판 "2승",1판 "1승")
//		
//		
//		for(int i = 0; i < gameCount; i++) {
//			System.out.println("가위바위보 하나 중 입력: ");
//			
//			String userPick = sc.next(); // 사용자가 "가위", "바위", "보" 중 입력
//			int com = (int) (Math.random() * 3); // 컴퓨터가 0~2 랜덤 선택
//			String[] rockScissorsPaper = { "가위", "바위", "보" }; // 위에서 나온 랜덤 숫자와 배열을 통해 가위바위보 문자열을 뽑아냄
//			
//			System.out.println(userPick);
//			System.out.println(rockScissorsPaper[com]);
//			
//			if (userPick.equals(rockScissorsPaper[com])) { 
//				System.out.println("사용자 : " + userPick);
//				System.out.println("컴퓨터 : " + rockScissorsPaper[com]);
//				System.out.println("비겼습니다!!!");
//			} else if (userPick.equals("가위") && rockScissorsPaper[com].equals("보")) { 
//				System.out.println("사용자 : " + userPick);
//				System.out.println("컴퓨터 : " + rockScissorsPaper[com]);
//				System.out.println("이겼습니다!!!");
//				userWinCount++;
//			} else if (userPick.equals("바위") && rockScissorsPaper[com].equals("가위")) {
//				System.out.println("사용자 : " + userPick);
//				System.out.println("컴퓨터 : " + rockScissorsPaper[com]);
//				System.out.println("이겼습니다!!!");
//				userWinCount++;
//			} else if (userPick.equals("보") && rockScissorsPaper[com].equals("바위")) {
//				System.out.println("사용자 : " + userPick);
//				System.out.println("컴퓨터 : " + rockScissorsPaper[com]);
//				System.out.println("이겼습니다!!!");
//				userWinCount++;
//			} else { // 유저가 질 경우
//				System.out.println("사용자 : " + userPick);
//				System.out.println("컴퓨터 : " + rockScissorsPaper[com]);
//				System.out.println("졌습니다!!!");
//				comWinCount++;
//			}
//			
//			if(userWinCount == goalCount || comWinCount == goalCount) {
//				break;
//			}
//		}
//		
//		if (userWinCount > comWinCount) {
//			System.out.println("### 사용자 승!!!");
//			System.out.println("이긴 횟수 : " + userWinCount + " 회");
//			System.out.println("진 횟수 : " + comWinCount + " 회");
//			
//		}
//		
//		if (userWinCount < comWinCount) {
//			System.out.println("### 컴퓨터 승!!!");
//			System.out.println("이긴 횟수 : " + userWinCount + " 회");
//			System.out.println("진 횟수 : " + comWinCount + " 회");
//			
//		}
//		
//		// 게임을 다 끝냈을 때 비긴 경우
//		if (userWinCount == comWinCount) {
//			System.out.println("승부가 나지 않았습니다.. 게임을 종료합니다.");
//		}
//	}
//}

/*------------------------------------------------------------------------------*/

// 교수님 풀이

public class GameTest {
	public static void main(String[] args) {
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.println("번호를 입력하세요.");

		// Ctrl + 1
		Scanner sc = new Scanner(System.in); // Ctrl + Shift + O : 자동 임포트

		int menu = sc.nextInt(); // <- 스캐너에서 nextInt를 호출했을때 입력을 기다린다

		int loop; // 메뉴에 따라 게임 반복 횟수 저장 변수
		switch (menu) {

		case 1:
			loop = 5;
			break;
		case 2:
			loop = 3;
			break;
		case 3:
			loop = 1;
			break;

		default:
			System.out.println("번호를 잘못 입력하셨습니다.");
			return;
		}

		int userWinCount = 0; // 사용자 승리 수
		int comWinCount = 0; // 컴퓨터 승리 수

		do {
			System.out.print("가위바위보 중 하나 입력 : ");
			String input = sc.next();

			int user = -1;
			switch (input) {
			case "가위":
				user = 1;
				break;

			case "바위":
				user = 2;
				break;

			case "보":
				user = 3;
				break;

			default:
				System.out.println("잘못 입력하셨습니다. 졌습니다!!!");
				comWinCount++;
				continue;
			}

			int com = (int) (Math.random() * 3) + 1;

			boolean case1 = user == 1 && com == 2; // 컴퓨터 승
			boolean case2 = user == 1 && com == 3; // 사용자 승
			boolean case3 = user == 2 && com == 1; // 사용자 승
			boolean case4 = user == 2 && com == 3; // 컴퓨터 승
			boolean case5 = user == 3 && com == 1; // 컴퓨터 승
			boolean case6 = user == 3 && com == 2; // 사용자 승

			if (case2 || case3 || case6) {
				userWinCount++;
				System.out.println("이겼습니다!!!");
			} else if (case1 || case4 || case5) {
				comWinCount++;
				System.out.println("졌습니다!!!");
			} else {
				System.out.println("비겼습니다!!!");
			}

			if (menu == 1 && userWinCount > 2 || comWinCount > 2) {
				break;
			} else if (menu == 2 && userWinCount > 1 || comWinCount > 1) {
				break;
			}
		} while (--loop != 0);

		if (userWinCount > comWinCount) {
			System.out.println("### 유저 승!!!");
		} else if (userWinCount < comWinCount) {
			System.out.println("### 컴퓨터 승!!!");
		} else {
			System.out.println("### 무승부!!!");
		}
	}
}
