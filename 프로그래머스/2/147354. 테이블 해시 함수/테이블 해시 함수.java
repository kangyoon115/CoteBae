import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 1. 정렬 (col은 1부터 시작하므로 -1)
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] != b[col - 1]) {
                return a[col - 1] - b[col - 1];
            } else {
                return b[0] - a[0]; // 첫 번째 열 내림차순
            }
        });

        // 2. S_i 계산 후 XOR
        int answer = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int val : data[i]) {
                sum += val % (i + 1);
            }
            answer ^= sum;
        }

        return answer;
    }
}