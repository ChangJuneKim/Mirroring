import java.util.Scanner;

/*
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1 
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
 */
public class SpaceDivideTest {
	
	private static int white;
	private static int green;
	private static int[][] spaces;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();  // 한 변의 길이
		
		// 주어진 2차원 데이터 배열에 저장
		spaces = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				spaces[i][j] = sc.nextInt();
			}
		}
		
		// 주어진 영역에 대해 초록색이나 하얀색으로 이루어져 있는지 확인 (재귀함수로 구현)
		cut(0, 0, N);
		System.out.println(white);
		System.out.println(green);
	}

	// r: 탐색 시작지점의 행, c: 탐색 시작지점의 열, size: 탐색 영역 한 변의 길이
	// 초록색: 1, 흰색: 0
	private static void cut(int r, int c, int size) {
		
		// 해당 영역의 색상 확인
		int sum = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				sum += spaces[i][j];
			}
		}
		
		// 전체 영역이 초록색이면 (기저부분)
		if (sum == size * size) {
			green++;
		}
		// 전체 영역이 흰색이면 (기저부분)
		else if (sum == 0) {
			white++;
		}
		// 유도 부분
		else {  // 색상이 섞여 있는 경우
			int half = size / 2;
			
			// 4개로 쪼개기: 분할된 각 영역의 공간도 온전한 하나의 공간으로 본다면 동일한 작업 수행해야 함 (재귀이용)
			cut(r, c, half);  // 좌상
			cut(r, c + half, half);  // 우상
			cut(r + half, c, half);  // 좌하
			cut(r + half, c + half, half);  // 우하
		}
	}
}
