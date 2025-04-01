class Solution {
public int[] solution(int n) {
    // 전체 배열 크기 계산 (1부터 n까지의 합)
    int size = n * (n + 1) / 2;
    int[][] triangle = new int[n][n];
    
    int value = 1; // 채울 값
    int row = 0, col = 0; // 현재 위치
    int direction = 0; // 0: 아래, 1: 오른쪽, 2: 왼쪽 위
    
    while (value <= size) {
        triangle[row][col] = value++;
        
        // 다음 위치 계산
        if (direction == 0) { // 아래로
            if (row + 1 >= n || triangle[row + 1][col] != 0) {
                direction = 1;
                col++;
            } else {
                row++;
            }
        } else if (direction == 1) { // 오른쪽으로
            if (col + 1 >= n || triangle[row][col + 1] != 0) {
                direction = 2;
                row--;
                col--;
            } else {
                col++;
            }
        } else { // 왼쪽 위로
            if (triangle[row - 1][col - 1] != 0) {
                direction = 0;
                row++;
            } else {
                row--;
                col--;
            }
        }
    }
    
    // 결과 배열로 변환
    int[] result = new int[size];
    int index = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            result[index++] = triangle[i][j];
        }
    }
    
    return result;
}
}