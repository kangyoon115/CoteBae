class Solution {
    public int solution(int left, int right) {
        int result = 0;

        for (int i = left; i <= right; i++) {
            boolean isSquare = false;

            // 제곱수인지 확인
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    isSquare = true;
                    break;
                }
            }

            // 제곱수이면 빼고, 아니면 더하기
            if (isSquare) {
                result -= i;  // 약수의 개수가 홀수인 경우 (제곱수)
            } else {
                result += i;  // 약수의 개수가 짝수인 경우
            }
        }

        return result;
    
    }
}