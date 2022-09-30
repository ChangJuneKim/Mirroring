import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProfessorSolution {

	private static final int RED = 0;
	private static final int GREEN = 1;
	private static final int BLUE = 2;

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		int N = Integer.parseInt(in.readLine());

		int[][] data = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				data[i][j] = Integer.parseInt(split[j]);
			}
		}

		/**
		 * 2. 알고리즘 풀기
		 */
		// 1. 동적 테이블 생성
		int[][] D = new int[N + 1][3];  // 집은 1번부터 시작

		// 2. 베이스 값 채우기
		D[0][RED] = 0;  // 0번 집을 빨간색으로 칠하는데 드는 비용은 0 (0번 집은 존재하지 않음)
		D[0][GREEN] = 0;  // 0번 집을 초록색으로 칠하는데 드는 비용은 0 (0번 집은 존재하지 않음)
		D[0][BLUE] = 0;  // 0번 집을 파란색으로 칠하는데 드는 비용은 0 (0번 집은 존재하지 않음)

		// 3. 점화식을 이용하여 상향식으로 동적테이블 채우기
		for (int i = 1; i <= N; i++) {

			// i번째 집이 빨간색을 선택했을 경우 총 최소비용 구하기
			int min = Integer.MAX_VALUE;
			min = Math.min(min, D[i - 1][GREEN]);  // 초록색
			min = Math.min(min, D[i - 1][BLUE]);  // 파란색
			D[i][RED] = min + data[i][RED];  // i번째 집을 빨간색으로 칠했을 때의 최소비용

			// i번째 집이 초록색을 선택했을 경우 총 최소비용 구하기
			min = Integer.MAX_VALUE;
			min = Math.min(min, D[i - 1][RED]);  // 빨간색
			min = Math.min(min, D[i - 1][BLUE]);  // 파란색
			D[i][GREEN] = min + data[i][GREEN];  // i번째 집을 초록색으로 칠했을 때의 최소비용

			// i번째 집이 파란색을 선택했을 경우 총 최소비용 구하기
			min = Integer.MAX_VALUE;
			min = Math.min(min, D[i - 1][RED]);  // 빨간색
			min = Math.min(min, D[i - 1][GREEN]);  // 초록색
			D[i][BLUE] = min + data[i][BLUE];  // i번째 집을 파란색으로 칠했을 때의 최소비용
		}

		/**
		 * 3. 정답 출력
		 */
		// 마지막 집에서 각 색깔을 칠할 때 비용 중 최소비용이 답이 된다.
		int min = Integer.MAX_VALUE;
		min = Math.min(min, D[N][RED]);  // 마지막 집을 빨간색으로 칠한 경우
		min = Math.min(min, D[N][GREEN]);  // 마지막 집을 초록색으로 칠한 경우
		min = Math.min(min, D[N][BLUE]);  // 마지막 집을 파란색으로 칠한 경우

		sb.append(min);
		System.out.println(sb);
	}
}
