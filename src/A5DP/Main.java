package A5DP;

import java.util.Arrays;

//        멀리 뛰기 : 프로그래머스 12914 - ㅎㅇ
public class Main {
    public static void main(String[] args) {
        int n = 10;
//        n번째 자리의 경우의 수는 n-1번째의 경우의수와 n-2번째 경우의 수의 합
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
    }
}
