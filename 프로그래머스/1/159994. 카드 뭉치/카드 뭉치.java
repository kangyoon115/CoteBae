class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0; // cards1 배열의 현재 인덱스
        int index2 = 0; // cards2 배열의 현재 인덱스
        
        // goal 배열의 모든 단어를 순서대로 검사
        for (int i = 0; i < goal.length; i++) {
            String word = goal[i];
            
            // 현재 목표 단어가 cards1에서 나와야 하는 경우
            if (index1 < cards1.length && cards1[index1].equals(word)) {
                index1++; // cards1의 다음 인덱스로 이동
            }
            // 현재 목표 단어가 cards2에서 나와야 하는 경우
            else if (index2 < cards2.length && cards2[index2].equals(word)) {
                index2++; // cards2의 다음 인덱스로 이동
            }
            // 현재 목표 단어가 두 카드 뭉치 중 어느 곳에도 없으면 "No" 반환
            else {
                return "No";
            }
        }
        
        // 모든 목표 단어를 올바른 순서로 사용할 수 있으면 "Yes" 반환
        return "Yes";
    }
}