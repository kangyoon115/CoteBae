public class Solution {
    public int solution(int[][] board) {
        int max = 0;
        int row = board.length;
        int col = board[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = board[i][j];  // 첫 행/열은 그대로
                } else if (board[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(
                        dp[i - 1][j],
                        dp[i][j - 1]),
                        dp[i - 1][j - 1]
                    ) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;  // 넓이 = 한 변의 길이²
    }
}
