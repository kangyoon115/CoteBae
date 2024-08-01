import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
             // 이름과 그리움 점수를 매핑하는 해시맵 생성
        Map<String, Integer> yearningMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }

        // 각 사진별로 추억 점수를 계산하여 결과 배열에 추가
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                String person = photo[i][j];
                // person이 yearningMap에 있는지 확인하고 점수를 더함
                if (yearningMap.containsKey(person)) {
                    sum += yearningMap.get(person);
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}