class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] allowed = {"aya", "ye", "woo", "ma"};

        // babbling 배열의 각 단어를 검사
        for (int i = 0; i < babbling.length; i++) {
            String word = babbling[i];
            boolean isValid = true;
            String previous = "";

            // 문자열의 모든 부분이 허용된 문자열로만 구성되었는지 확인
            while (word.length() > 0) {
                boolean matched = false;

                // 허용된 문자열 배열을 검사
                for (int j = 0; j < allowed.length; j++) {
                    if (word.startsWith(allowed[j])) {
                        // 같은 발음이 연속되면 유효하지 않음
                        if (allowed[j].equals(previous)) {
                            isValid = false;
                            break;
                        }
                        previous = allowed[j]; // 현재 발음을 기록
                        word = word.substring(allowed[j].length()); // 허용된 문자열 제거
                        matched = true;
                        break;
                    }
                }

                if (!matched) {
                    isValid = false;
                    break;
                }
            }

            // 문자열이 유효한 경우 개수 증가
            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}
