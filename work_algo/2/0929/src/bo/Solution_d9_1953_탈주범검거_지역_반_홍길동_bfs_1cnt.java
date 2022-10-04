package a0929.add;

import java.io.*;
import java.util.*;

public class Solution_d9_1953_탈주범검거_지역_반_홍길동_bfs_1cnt {
	static int[] di={-1,0,0,1};//상0좌1우2하3 3-상0=3하,3-좌1=2우 
	static int[] dj={0,-1,1,0};
	                       //0,1상하좌우,2상하,3좌우,4상우,5하우,6하좌,7상좌
	static String[] type={null,"0312",   "03", "12", "02", "32", "31", "01"};
	static int N,M,R,C,L,map[][];
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d9_1953.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int T=Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++){
			st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			map=new int[N][M];
			v=new boolean[N][M];
			for(int i=0; i<N; i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<M; j++){
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//for(int[] a:map) System.out.println(Arrays.toString(a));System.out.println();
			sb.append("#").append(tc).append(" ").append(bfs(R,C,1)).append("\n");
		}		
		System.out.print(sb.toString());
		br.close();
	}
	static int bfs(int i,int j,int time){
		int ans=0;
		ArrayDeque<int[]> q=new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j,time});
		ans++;
		while(!q.isEmpty()){
			int[] ij=q.poll();
			i=ij[0];
			j=ij[1];
			time=ij[2];
			if(time==L) break;
			String cur=type[map[i][j]];
			for(int c=0; c<cur.length(); c++){
				int d=cur.charAt(c)-'0';
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<M
						&& map[ni][nj]!=0
						&& !v[ni][nj]
						&& type[map[ni][nj]].contains(""+(3-d))){//Integer.toString(3-d)
					v[ni][nj]=true;
					q.offer(new int[]{ni,nj,time+1});
					ans++;
				}
			}
		}
		return ans;
	}
}












