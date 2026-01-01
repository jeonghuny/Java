package A3bfs;

import java.util.*;

public class A02Bfs최단거리 {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] nodes = {{2,0},{0,1},{1,3},{2,3},{2,4}};
        visited = new boolean[5];

        for(int i=0; i<5; i++){
            adjList.add(new ArrayList<>());
        }

//        0부터 target까지 갖는 최단거리
        int target = 4;
        for(int[] n : nodes){
            adjList.get(n[0]).add(n[1]);
            adjList.get(n[1]).add(n[0]);
        }

        for(List<Integer> l : adjList){
            l.sort(Comparator.naturalOrder());
        }
        System.out.println(adjList);

        Queue<int[]> myQue = new LinkedList<>();
        myQue.add(new int[]{0,0});
        visited[0]=true; // int배열 안에는 {노드번호, 거리}
        int answer = -1;
        loop1:
        while(!myQue.isEmpty()){
            int[] temp = myQue.poll();
//            if(temp[0]==target){
//                answer = temp[1];
//            }
            for(int a : adjList.get(temp[0])){
                if(visited[a]) continue;
                myQue.add(new int[] {a,temp[1]+1});
                visited[a]=true;
                if(target==a){
                    answer = temp[1]+1;
                    break loop1;
                }
            }
        }
        System.out.println(answer);
    }
}
