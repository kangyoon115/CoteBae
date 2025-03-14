import java.util.*;

class Solution {
    public int solution(int n) {
        // 문제에서 요구하는 나머지 연산을 위한 상수
        final int MOD = 1000000007;
        
        // n이 1이나 2인 경우는 미리 처리
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // dp[i]는 2xi 크기의 직사각형을 채우는 방법의 수
        int[] dp = new int[n + 1];
        
        // 기본 케이스 설정
        dp[1] = 1; // 2x1 직사각형은 채우는 방법이 1가지
        dp[2] = 2; // 2x2 직사각형은 채우는 방법이 2가지
        
        // 동적 프로그래밍으로 나머지 경우 계산
        for (int i = 3; i <= n; i++) {
            // dp[i] = dp[i-1] + dp[i-2]
            // dp[i-1]: 마지막에 세로 타일 하나를 놓는 경우
            // dp[i-2]: 마지막에 가로 타일 두 개를 놓는 경우
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        
        return dp[n];
    }
}