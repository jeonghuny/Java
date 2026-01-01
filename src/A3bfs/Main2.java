package A3bfs;

import java.util.LinkedList;
import java.util.Queue;
// 게임 맵 최단거리 - 프로그래머스
public class Main2 {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1}};
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0,1});
        visited[0][0] = true;
        int answer = -1;
        loop1:
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if(nx>=0 && ny>=0 && nx<maps.length && ny<maps[0].length){
                    if(maps[nx][ny] == 1 && !visited[nx][ny]){
                        q.add(new int[]{nx,ny,now[2]+1}); // 큐에다 더하는 시점에 종료로직 쓰기
                        if(nx==maps.length-1 && ny==maps[0].length-1){
                            answer = now[2] + 1;
                            break loop1;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
