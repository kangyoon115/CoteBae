import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1); // 초기 값을 -1로 설정

        HashMap<Character, Integer> map = new HashMap<>(); // 문자와 인덱스를 저장하는 해시맵

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) { // 문자가 이미 등장한 경우
                int prevIndex = map.get(c); // 이전 인덱스
                answer[i] = i - prevIndex; // 거리 계산 후 배열에 저장
            }

            map.put(c, i); // 현재 문자와 인덱스를 해시맵에 저장
        }

        return answer;
    }
}