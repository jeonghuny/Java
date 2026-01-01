package A5DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A04문자열수열 {
//    가장 긴 증가하는 부분 수열(11053) : 백준 ;;

//    가장 긴 증가하는 부분 수열4(14002) : 백준(DP+역추적) ;;
//    => 별도의 배열을 하나 더 만들어서, 직전의 값(index)을 기록.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        dp식 : max(dp[n-1], dp[n-2]...) 중에 arr[n]보다 작은 dp값 + 1
        int[] prevArr = new int[N];
        Arrays.fill(prevArr, -1);
        for(int i=0; i<dp.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && dp[j] > max){
                    max = dp[j];
                    prevArr[i] = j;
                }
            }
            dp[i] = max + 1;
        }

        int maxIndex = 0;
        for(int i=1; i<N; i++){
            if(dp[i] > dp[maxIndex]){
                maxIndex = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(arr[maxIndex]);
        while(true){
            maxIndex = prevArr[maxIndex];
            if(maxIndex == -1){
                break;
            }
            list.add(arr[maxIndex]);
        }

        list.sort(Comparator.naturalOrder());

        System.out.println(Arrays.stream(dp).max().getAsInt());
        for(int n : list){
            System.out.print(n + " ");
        }


    }
}
