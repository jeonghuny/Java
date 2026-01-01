package A5DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A01계단관련 {
    public static void main(String[] args) throws IOException {
//        멀리 뛰기 : 프로그래머스 - ㅎㅇ

//        계단오르기 : 백준 - ㅎㅇ
        
        // 앞에서부터 경우의수 따지면 -> 귀납적 정의 해결
        // 위에서부터 구하면 -> 연역적

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n + 1];
        int[] dp = new int[n + 1];

        for(int i=1; i<=n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }
        if(n>=1) dp[1] = stair[1];
        if(n>=2) dp[2] = stair[1] + stair[2];
        if(n>=3) dp[3] = Math.max((stair[1] + stair[3]) , (stair[2] + stair[3]));

        for(int i=4; i<=n; i++){
            dp[i] = Math.max((dp[i-2]+stair[i]), dp[i-3]+stair[i-1]+stair[i]);
        }
        System.out.println(dp[n]);
    }
}
