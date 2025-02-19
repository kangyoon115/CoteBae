import java.util.*;

class Solution {
    public int solution(String dirs) {
        HashSet<String> visitedPaths = new HashSet<>();
        
        int x = 0, y = 0; // 현재 위치
        
        for (char dir : dirs.toCharArray()) {
            int nextX = x, nextY = y;
            
            if (dir == 'U') nextY += 1; // 위로 이동
            else if (dir == 'D') nextY -= 1; // 아래로 이동
            else if (dir == 'R') nextX += 1; // 오른쪽 이동
            else if (dir == 'L') nextX -= 1; // 왼쪽 이동

            // 이동 범위를 벗어나면 무시
            if (nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5) continue;

            // 길을 (현재 -> 다음) & (다음 -> 현재)로 저장
            String path1 = x + "," + y + "->" + nextX + "," + nextY;
            String path2 = nextX + "," + nextY + "->" + x + "," + y;
            visitedPaths.add(path1);
            visitedPaths.add(path2);

            // 현재 위치 갱신
            x = nextX;
            y = nextY;
        }

        return visitedPaths.size() / 2;
    }
}
