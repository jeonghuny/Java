package A3bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//    촌수계산 : 백준 - ㅎㅇ

//    가장 먼 노드 : 프로그래머스 - ㅎㅇ

public class A03인접리스트활용거리문제 {
    static List<Integer>[] graph;
    static int n,m;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        bfs(person1, person2);
    }
    static void bfs(int person1, int person2){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{person1,0});
        visited[person1] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int next : graph[now[0]]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[] {next,now[1]+1});
                    if(person2 == next){
                        System.out.println(now[1]+1);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
