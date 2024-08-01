class Solution {
    public int solution(int[] nums) {
        int totalCount = nums.length;
        int maxSelectCount = totalCount / 2;
        
        // 최대 200,000개의 폰켓몬 종류를 가정하여 충분히 큰 배열 생성
        // 실제 문제에서는 폰켓몬 종류의 범위가 적을 수 있습니다.
        boolean[] seen = new boolean[200001]; 
        int uniqueCount = 0;
        
        // 각 폰켓몬 종류를 확인하고 유일한 종류의 수를 카운트
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!seen[num]) {
                seen[num] = true;
                uniqueCount++;
            }
        }
        
        // 유일한 폰켓몬 종류의 수와 선택 가능한 폰켓몬 수 중 더 작은 값을 반환
        return Math.min(uniqueCount, maxSelectCount);
    }
}