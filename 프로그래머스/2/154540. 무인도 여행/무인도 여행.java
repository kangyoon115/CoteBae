import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; //상,하
    static int[] dy = {0, 0, -1, 1}; //좌,우
    public static List<Integer> solution(String[] maps){
        List<Integer> answer = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[map.length][map[0].length];
        //배열로 저장
        for(int i=0;i<maps.length;i++){
            map[i] = maps[i].toCharArray();
        }

        //bfs 탐색
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(!visited[i][j] && map[i][j] != 'X'){
                    answer.add(bfs(i, j));
                }
            }
        }

        //예외처리
        if(answer.size() == 0){
            answer.add(-1);
        }
        Collections.sort(answer);
        return answer;
    }

    public static int bfs(int x, int y){
        int sum = 0; //현재 영역의 총합
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y}); //시작지점
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            sum += map[cx][cy]-'0'; //문자->정수
            for(int i=0;i<4;i++){
                //4방향 탐색
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                //범위 초과 방지
                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
                    continue;
                if(!visited[nx][ny] && map[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return sum;
    }
}