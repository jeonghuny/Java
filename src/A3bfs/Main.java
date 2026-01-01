package A3bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 숫자판 점프 - 백준 -2210번 - ㅎㅇ
public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Set<String> set = new HashSet<>();
    static int[][] numBoard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numBoard = new int[5][5];

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                numBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                dfs(i,j,"");
            }
        }
        System.out.println(set.size());
    }
    static void dfs(int start, int end, String num){
        if(num.length()==6){
            set.add(num);
            return;
        }
        for(int i=0; i<4; i++){
            int nx = dx[i] + start;
            int ny = dy[i] + end;

            if(nx>=0 && ny>=0 && nx<5 && ny<5){
                dfs(nx,ny,num+numBoard[start][end]);
            }
        }
        return;
    }
}
