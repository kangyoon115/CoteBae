import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        // 배열 A 오름차순 정렬
        Arrays.sort(A);
        // 배열 B 오름차순 정렬 후 뒤집어서 내림차순 만들기
        Arrays.sort(B);
        for (int i = 0, j = B.length - 1; i < j; i++, j--) {
            int temp = B[i];
            B[i] = B[j];
            B[j] = temp;
        }

        // 정렬된 A와 내림차순 정렬된 B의 각 요소를 곱하여 누적합 계산
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }

        return answer;
    }
}
