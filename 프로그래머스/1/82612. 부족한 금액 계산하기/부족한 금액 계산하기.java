class Solution {
    public long solution(int price, int money, int count) {
       long totalCost = 0;

        // 놀이기구를 count번 탈 때 필요한 총 비용 계산
        for (int i = 1; i <= count; i++) {
            totalCost += (long) price * i; // price * i를 long으로 형변환하여 오버플로우 방지
        }

        // 자신이 가지고 있는 금액에서 totalCost를 뺀 결과 계산
        long result = totalCost - money;

        // 부족한 금액이면 양수를 반환, 충분하면 0을 반환
        return result > 0 ? result : 0;
    
    }
}