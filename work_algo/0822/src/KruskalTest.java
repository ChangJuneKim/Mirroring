import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalTest {
	static class Edge implements Comparable<Edge> {
		int from, to;
		long weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return Integer.compare(this.weight, o.weight);
			return (int) (this.weight - o.weight);
		}

	}

	static int[] parents;
	static int V, E;
	static Edge[] edgeList;

	static void make(int V) { // 크기가 1인 서로소 집합 생성
		parents = new int[V + 1];
		for (int i = 1; i < V + 1; i++) { // 모든 노드가 자신을 부모로하는 (대표자) 집합으로 만듦
			parents[i] = i;
		}
	}

	static int find(int a) { // a 의 대표자 찾기
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]); // 우리의 대표자를 나의 부모로.. path compression;
	}

	static boolean union(int a, int b) { // 리턴 값 : true ==> union 성공
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) { // 대장이 같으면 같은 집합(우리 식구아이가 ㅋㅋ)
			return false; // -> 같은 식구 끼리는 합칠수가 없기때문
		}

		parents[bRoot] = aRoot; // bRoot의 부모를 aRoot 로 한다 (즉 b를 a에 합쳤다)
		return true;
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			String[] split = br.readLine().split(" ");
			V = Integer.valueOf(split[0]);
			E = Integer.valueOf(split[1]);

			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				split = br.readLine().split(" ");
				
				int a = Integer.parseInt(split[0]);
				int b = Integer.parseInt(split[1]);
				int c = Integer.parseInt(split[2]);
				edgeList[i] = new Edge(a, b, c);
			}

			make(V);
			Arrays.sort(edgeList);

			long result = 0;
			long count = 0;
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					count++;
					result += edge.weight;
					if (count == V - 1)
						break;
				}
			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}
}
