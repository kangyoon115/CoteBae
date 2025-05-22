class Solution {
    //https://minheelog.tistory.com/15
    int isTrue;           // 거리두기 준수 여부
    String[] room;
    boolean[][] visited;   
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int n = 0; n < 5; n++) {  // n: 대기실 번호
            // 거리두기 준수 여부와 room초기화
            isTrue = 1;
            room = places[n];
            
            for (int x = 0; x < 5; x ++) {
                for (int y = 0; y < 5; y++) {
                    visited = new boolean[5][5];  // 방문기록 초기화
                    if (room[x].charAt(y) == 'P') {
                        visited[x][y] = true;
                        checkSeat(x, y, 0);
                    }
                    if (isTrue == 0) break; // 거리두기 준수하지 않았을 경우 더 이상 탐색하지 않아도 됨
                }
                if (isTrue == 0) break; // 거리두기 준수하지 않았을 경우 더 이상 탐색하지 않아도 됨
            }
            answer[n] = isTrue;
        }
        
        return answer;
    }
    
    public void checkSeat(int x, int y, int dst) {
        
        if (dst != 0 && room[x].charAt(y) == 'P') { 
            isTrue = 0;
            return;
        }
        
        if (room[x].charAt(y) == 'X' || dst == 2) return; // 파티션이거나 맨하탄거리가 2일 경우 탐색 종료
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 범위를 벗어나거나 이미 방문한 경우
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny]) continue;
            
            visited[nx][ny] = true;
            checkSeat(nx, ny, dst + 1);
        }
        
    }
}