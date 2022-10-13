package ctalgo01_부울경_04반_김창준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_5607_Solution {
    final long MOD = 1234567891;
    int n, r;
    long fact[];
    
    public static void main(String[] args) throws IOException {
        new Swea_5607_Solution().solution();
    }
    
    public long pow(long a, long remain) {
        if (remain == 0) return 1;
        else if (remain == 1) return a;
        if (remain % 2 == 0) {
            long temp = pow(a, remain / 2);
            return (temp * temp) % MOD;
        }
        long temp = pow(a, remain - 1) % MOD;
        return (temp * a) % MOD;
    }
    
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int test = Integer.parseInt(br.readLine());
        
        fact = new long[1000001];
        fact[0] = 1;
        
        for (int i = 1; i < 1000001; i++) {
            fact[i] = fact[i - 1] * i;
            fact[i] %= MOD;
        }
        
        for (int t = 1; t <= test; t++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            
            long up = 1, down = 1;
            up = fact[n];
            down = (fact[n - r] * fact[r]) % MOD;
            down = pow(down, MOD - 2);
            
            System.out.println("#" + t + " " + (up * down) % MOD);
        }
    }
    
}