class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3]; // 점수를 저장할 배열
        int index = -1; // 현재 처리 중인 기회의 인덱스
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            if (Character.isDigit(c)) {
                index++; // 새로운 기회를 시작
                if (c == '1' && dartResult.charAt(i + 1) == '0') { // 10점 처리
                    scores[index] = 10;
                    i++; // 0을 건너뛰기
                } else {
                    scores[index] = c - '0';
                }
            } else if (c == 'S') {
                scores[index] = (int) Math.pow(scores[index], 1);
            } else if (c == 'D') {
                scores[index] = (int) Math.pow(scores[index], 2);
            } else if (c == 'T') {
                scores[index] = (int) Math.pow(scores[index], 3);
            } else if (c == '*') {
                scores[index] *= 2;
                if (index > 0) { // 이전 점수도 2배 처리
                    scores[index - 1] *= 2;
                }
            } else if (c == '#') {
                scores[index] *= -1;
            }
        }
        
        // 최종 점수 합산
        int answer = 0;
        for (int score : scores) {
            answer += score;
        }
        
        return answer;
    }
}
