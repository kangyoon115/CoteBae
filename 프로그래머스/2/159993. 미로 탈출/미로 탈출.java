import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int n = maps.length, m = maps[0].length();
        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;

        // 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') { sx = i; sy = j; }//시작점
                if (c == 'L') { lx = i; ly = j; }//레버
                if (c == 'E') { ex = i; ey = j; }//출구
            }
        }

        int toLever = bfs(maps, sx, sy, 'L'); // 시작->레버
        int toExit  = bfs(maps, lx, ly, 'E'); // 레버->출구

        if (toLever == -1 || toExit == -1) return -1;
        return toLever + toExit;
    }

    int bfs(String[] map, int x, int y, char target) {
        int n = map.length, m = map[0].length();
        boolean[][] visit = new boolean[n][m];//방문여부
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});//{x,y,현재거리}
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (map[cur[0]].charAt(cur[1]) == target) return cur[2];

            //상,하,좌,우 이동
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visit[nx][ny] && map[nx].charAt(ny) != 'X') {
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        return -1;
    }
}
