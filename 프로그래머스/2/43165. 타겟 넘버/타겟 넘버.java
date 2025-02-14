class Solution {
    public int solution(int[] numbers, int target) {
          return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int currentSum) {
        // 모든 숫자를 다 사용했을 때
        if (index == numbers.length) {
            // 현재 합이 타겟 넘버와 같으면 경우의 수로 카운트
            return currentSum == target ? 1 : 0;
        }

        // 현재 숫자를 더하거나 뺀 결과를 재귀적으로 탐색
        return dfs(numbers, target, index + 1, currentSum + numbers[index])
             + dfs(numbers, target, index + 1, currentSum - numbers[index]);
    }
}