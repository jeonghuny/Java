package A4greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A02그리디활용문제 {
    public static void main(String[] args) throws IOException {
//        체육복 : 프로그래머스 -> 왼쪽에 있는 친구부터 주는 당장의 선택은 최적의 결과 보장 (42862)

//        수리공 항승 : 백준 -> 가장 왼쪽부터 붙여나가는 선택은 손해가 없는 최적의 선택 보장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        double[] loca = new double[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            loca[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(loca);

        // 테이프가 덮을 수 있는 끝 위치
        // (구멍 위치 - 0.5 + 테이프 길이)
        double end = loca[0] - 0.5 + L;
        int count = 1;

        for(int i=1; i<N; i++){
            if(loca[i] + 0.5 > end){
                count++;
                end = loca[i] - 0.5 + L;
            }
        }
        System.out.println(count);
    }
}
