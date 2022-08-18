package bo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2667 {

	static int N;
	static int[][] map;
	static int[] dr= {-1,0,1, 0}; //CW
	static int[] dc= { 0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for (int i = 0; i < N; i++) {
			String s=br.readLine();
			char[] cs=s.toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j]=cs[j]-'0';
			}
		}//read end
		//logic 
		int group=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <N; j++) {
				if(map[i][j]==1) {
					group++;
					bfs(i,j,group+1);
				}
			}
		}
		
	}
    //map의 값을 g
	private static void bfs(int rr, int cc, int g) {
		Queue<int[]> que=new LinkedList<>();
		que.offer(new int[] {rr,cc});
		map[rr][cc]=g;
		while(!que.isEmpty()) {
			int [] cur=que.poll();
			int r=cur[0];
			int c=cur[1];
			for (int d = 0; d < 4; d++) {
				int nr=r+dr[d];
				int nc=c+dc[d];
				if(!check(nr,nc))continue;
				if(map[nr][nc]==1) {
					que.offer(new int[] {nr,nc});
					map[nr][nc]=g;
				}
			}
		}
	}
	private static boolean check(int r, int c) {
		return r>= 0 && r<N && c>=0 && c<N;
	}

}