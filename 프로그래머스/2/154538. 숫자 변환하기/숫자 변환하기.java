import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // 최소 연산 횟수를 저장할 배열
        int[] dp = new int[y + 1];
        
        // 초기화: 모든 값을 불가능한 값(-1)으로 설정
        Arrays.fill(dp, -1);
        
        // 시작점 x는 0번의 연산으로 도달 가능
        dp[x] = 0;
        
        // x부터 y까지 순차적으로 탐색
        for (int i = x; i <= y; i++) {
            // 현재 위치에 도달할 수 없으면 건너뛰기
            if (dp[i] == -1) continue;
            
            // 연산 1: i + n
            if (i + n <= y) {
                if (dp[i + n] == -1 || dp[i + n] > dp[i] + 1) {
                    dp[i + n] = dp[i] + 1;
                }
            }
            
            // 연산 2: i * 2
            if (i * 2 <= y) {
                if (dp[i * 2] == -1 || dp[i * 2] > dp[i] + 1) {
                    dp[i * 2] = dp[i] + 1;
                }
            }
            
            // 연산 3: i * 3
            if (i * 3 <= y) {
                if (dp[i * 3] == -1 || dp[i * 3] > dp[i] + 1) {
                    dp[i * 3] = dp[i] + 1;
                }
            }
        }
        
        // y에 도달하는 최소 연산 횟수 반환
        return dp[y];
    }
}