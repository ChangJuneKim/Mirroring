package bo0811;

// 재귀 - recursion - 자신이 자신을 호출
// for나  while을 사용하지 않는 순환문
// 반드시 종료 조건이 있어야한다!
// long은 20! 가고  9,000,000,000,000,000,000L
// int는 10! 정도 간다 2,100,000,000

// 1,000,000,000반복 0.7~8초 정도 걸린다 ( 어림잡아 1초당 10억 )

// 최단거리를 구할땐 BFS를 써라~
// 그 외에 뭐 갈수있냐 없냐 그런건 보통 DFS로 다 풀린다

public class FactorialTest {
	
	// recursion -> stack / dfs -> call stack
	// f(5) -> f(4) -> f(3) -> f(2) -> f(1) 끝까지 오면
	// f(5) -> f(4) -> f(3) -> f(2)
	// f(5) -> f(4) -> f(3)
	// f(5) -> f(4)
	// f(5)
	private static int fact(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			return n * fact(n - 1);
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i < 13; i++) {
			System.out.println(i + "팩토리얼 : " + fact(i));
		}
	}
}
