package A3bfs;

import java.util.*;

public class A01Bfs방문순서 {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] nodes = {{2,0},{0,1},{1,3},{2,3},{2,4}};
        visited = new boolean[5];

        for(int i=0; i<5; i++){
            adjList.add(new ArrayList<>());
        }

//        인접리스트에 인접해있는 노드값 담기
        for(int[] n : nodes){
//            양방향 간선인 경우
            adjList.get(n[0]).add(n[1]);
            adjList.get(n[1]).add(n[0]);
        }

//        정점번호가 작은것부터 방문하기 위한 정렬작업
        for(List<Integer> l : adjList){
            l.sort(Comparator.naturalOrder());
        }
        System.out.println(adjList);

        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(0);
        visited[0]=true;
        while(!myQue.isEmpty()){
            int temp = myQue.poll();
            System.out.println(temp);
            for(int a : adjList.get(temp)){
                if(visited[a]) continue;
                    myQue.add(a);
//                bfs에서 visited는 queue에 add하는 시점에 true세팅해야함.
                    visited[a]=true;
            }
        }
    }
}
