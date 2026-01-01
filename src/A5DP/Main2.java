package A5DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//        1이 포함되지 않을 수 있고, target을 못만들수도 있는 경우의 동전문제
//        동전2(2294) : 백준
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] dp = new int[k+1];

        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=k; i++){
            int min = Integer.MAX_VALUE;
            for(int j=0; j<coin.length; j++){
                if(i-coin[j] >= 0 && dp[i-coin[j]] < min){
                    min = dp[i-coin[j]];
                }
            }
           dp[i] = min + 1;
        }

    }
}
