import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = strings.clone();
        int len = answer.length;

        for (int i = 0; i < len-1 ; i++) {
            for (int j = 0; j < len -1- i; j++) {
                char char1 = answer[j].charAt(n);
                char char2 = answer[j + 1].charAt(n);

                // 첫 번째 기준: n번째 문자 비교
                if (char1 > char2) {
                    // 자리 바꾸기
                    String temp = answer[j];
                    answer[j] = answer[j + 1];
                    answer[j + 1] = temp;
                } else if (char1 == char2) {
                    // 두 번째 기준: 문자열 자체 비교
                    if (answer[j].compareTo(answer[j + 1]) > 0) {
                        // 자리 바꾸기
                        String temp = answer[j];
                        answer[j] = answer[j + 1];
                        answer[j + 1] = temp;
                    }
                }
            }
        }

        return answer;
    }
}
