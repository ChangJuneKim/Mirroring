package bo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Solution_숫자만들기1 {
    int T, N;
    int[] operator;
    int[] numbers;
    int min, max;
    
    public static void main(String[] args) throws IOException {
        new Solution_숫자만들기1().solution();
    }
    
    private void perm(int depth, int total) {
        if (depth == N) {
            min = Math.min(min, total);
            max = Math.max(max, total);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) continue;
            operator[i]--;
            // 더하기일 때
            if (i == 0) {
                perm(depth + 1, total + numbers[depth]);
            }
            
            // 더하기일 때
            if (i == 1) {
                perm(depth + 1, total - numbers[depth]);
            }
            
            // 더하기일 때
            if (i == 2) {
                perm(depth + 1, total * numbers[depth]);
            }
            
            // 더하기일 때
            if (i == 3) {
                perm(depth + 1, total / numbers[depth]);
            }
            operator[i]++;
        }
    }
    
    public void solution() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            
            operator = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operator[i] = Integer.parseInt(st.nextToken());
            }
            
            numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            
            perm(1, numbers[0]);
            
            sb.append("#").append(testCase).append(" ").append(max - min).append("\n");
        }
        System.out.println(sb);
    }
    
    
}
