package A5DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 배낭문제 : 여러개의 선택대상이 있고, 전체 자원한도내에서 선택조합을 구성하여 최대값/최소값을 구하는 문제
public class A05배낭문제 {
//    주어진 데이터를 1번만 사용가능
//    평범한 배낭(12865) - 백준, 벼락치기(14728) - 백준

//    주어진 데이터를 여러번 사용가능
//    호텔(1106) - 백준
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            String[] temp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(temp[0]);
            arr[i][1] = Integer.parseInt(temp[1]);
        }

        int[] dp = new int[K+1];
        for(int i=0; i<arr.length; i++){
            for(int j=K; j>=arr[i][0]; j--){
                dp[j] = Math.max(dp[j],dp[j-arr[i][0]] + arr[i][1]);
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
//뒤에서부터 순회해야
//→ 같은 물건을 한 번만 사용