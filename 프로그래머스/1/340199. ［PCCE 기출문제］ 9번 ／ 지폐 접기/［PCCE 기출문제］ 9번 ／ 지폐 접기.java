class Solution {
    public int solution(int[] wallet, int[] bill) {
        // 접은 횟수 초기화
        int answer = 0;

        // 반복문을 이용해 bill의 작은 값이 wallet의 작은 값보다 크거나
        // bill의 큰 값이 wallet의 큰 값보다 큰 동안 반복
        while (Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1]) || 
               Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1])) {
            // bill의 첫 번째 값이 두 번째 값보다 크면
            if (bill[0] > bill[1]) {
                bill[0] /= 2;  // bill[0]을 2로 나누고 나머지는 버림
            } else {
                bill[1] /= 2;  // bill[1]을 2로 나누고 나머지는 버림
            }
            // 접은 횟수 증가
            answer++;
        }

        return answer;
    }
}