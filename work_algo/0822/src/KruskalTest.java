import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalTest {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return Integer.compare(this.weight, o.weight);
			return this.weight - o.weight;
		}

	}

	static int[] parents;
	static int V, E;
	static Edge[] edgeList;

	static void make() { // 크기가 1인 서로소 집합 생성
		parents = new int[V];
		for (int i = 0; i < V; i++) { // 모든 노드가 자신을 부모로하는 (대표자) 집합으로 만듦
			parents[i] = i;
		}
	}

	static int find(int a) { // a 의 대표자 찾기
		if (parents[a] == a) {
			return a;
		}

		parents[a] = find(parents[a]); // 우리의 대표자를 나의 부모로.. path compression

		return parents[a];

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
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());

		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(
					Integer.valueOf(st.nextToken()),
					Integer.valueOf(st.nextToken()),
					Integer.valueOf(st.nextToken())
					);
		}
		
		make();
		Arrays.sort(edgeList);
		
		int result = 0;
		int count = 0;
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				count++;
				result += edge.weight;
				if(count == V - 1) break;
			}
		}
		
		System.out.println(result + " " + count);
	}
}
