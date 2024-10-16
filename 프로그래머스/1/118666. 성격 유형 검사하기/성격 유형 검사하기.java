
import java.util.Map;
import java.util.HashMap;

class Solution {

    public String solution(String[] survey, int[] choices) {
       
        /*
         * @Desc
         * 1. 검사지의 기준값을 구한다. (choice가 4일 때 0점)
         * 2. choice와 기준값을 비교한다.
         * 3. 0보다 작으면 성격 유형의 왼쪽 유형의 점수로, 0보다 크면 성격 유형의 오른쪽 유형의 점수로 계산.
         * 4. map에 성격 유형별 점수를 담는다.
         * 5. 점수가 같을 경우 사전순으로 선택한다.
         * 6. 성격 유형을 String 타입으로 리턴한다.
         */

        // 상수 선언
        int questionCnt = 7;
        int base = (int) (questionCnt / 2) + 1; // 기준 값은 4
        String personalityType = "RTCFJMAN";

        // 변수 선언
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        // 성격 유형별 점수 초기화
        for (String split : personalityType.split("")) {
            map.put(split, 0);
        }

        // 설문 조사 결과 분석
        for (int i = 0; i < survey.length; i++) {
            int score = choices[i] - base;
            String type = "";

            if (score >= 0) {
                type = survey[i].split("")[1];
            } else {
                type = survey[i].split("")[0];
                score *= -1;
            }

            map.put(type, map.get(type) + score);
        }

        // 성격 유형 계산
        if (map.get("T") > map.get("R")) {
            answer += "T";
        } else {
            answer += "R";
        }

        if (map.get("F") > map.get("C")) {
            answer += "F";
        } else {
            answer += "C";
        }

        if (map.get("M") > map.get("J")) {
            answer += "M";
        } else {
            answer += "J";
        }

        if (map.get("N") > map.get("A")) {
            answer += "N";
        } else {
            answer += "A";
        }

        return answer;
    }
}
