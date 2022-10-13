package ctalgo01_부울경_04반_김창준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
  
class Swea_3238_Solution
{
    public static void main(String args[]) throws Exception
    {
        long[] factorials = new long[100001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
               
            //N은 최대 100경, 2^64는 약 1800경
            long N = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            long P = Long.parseLong(st.nextToken());
               
            factorial(P,P,factorials);
               
            long ans = 1;
            //N과 R을 P진법으로 나타낸것의 조합 곱
            //
            while (R!=0) {
                //p진법 n번째 자리
                long N_p = N%P;
                long R_p = R%P;
                  
                //N_p<R_p인 항의 값은 항상 0
                if(N_p < R_p) ans = 0;
                //mod연산은 곱에대한 분배법칙이 성립되므로, 0인항이 나오면 답은 0이된다.
                if(ans == 0) break;
  
                //N_p C R_p 계산해서 ans에 더해준다. 
                ans = ((ans * factorials[(int)N_p])%P * pow((factorials[(int) R_p] * factorials[(int) (N_p-R_p)]) % P, P-2, P)) % P;
                  
                //p진법 표현의 다음 자리수를 보기 위해 p로 나눠준다.
                N /= P;
                R /= P;
            }
               
            System.out.printf("#%d %d\n",t,ans);
        }
    }
      
    //x^y (mod P) 
    //y=P-2, 약 12억이므로 단순히 x를 y제곱하면 곱하기 연산만 12억번이 필요하므로 제한시간인 4초내에 해결이 불가능하다.
    //
    //지수를 이진수로 나타내고, 이진수의 비트가 1일때 해당하는 밑을 곱해준다. 밑 또한 다음비트로 갈때 제곱하여 키워준다.
    //ex) 3^14 = 2^(1110(2)) * 2^(0(2)) * 4^(10(2)) * 16^(100(2)) * 32^(1000(2))
    public static long pow(long x, long y, long p) {
        long res = 1L;
        x = x%p;
           
        while (y>0) {
            if(y % 2 == 1) res = (res * x)%p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
      
    private static void factorial(long N, long P, long[] factorials) {
        int n = (int)N;
  
        factorials[0]=1;
        for(int i=1; i<=n; i++) {
            factorials[i]=factorials[i-1]*i%P;
        }
    }
}