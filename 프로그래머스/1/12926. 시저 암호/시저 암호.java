class Solution {
    public String solution(String s, int n) {
      StringBuilder answer = new StringBuilder(); // 결과 문자열을 만들기 위한 StringBuilder

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // 현재 문자를 가져옴

            if (Character.isLowerCase(c)) {
                char shifted = (char) ((c - 'a' + n) % 26 + 'a'); // 소문자 범위 내에서 밀기
                answer.append(shifted);
            } else if (Character.isUpperCase(c)) {
                char shifted = (char) ((c - 'A' + n) % 26 + 'A'); // 대문자 범위 내에서 밀기
                answer.append(shifted);
            } else {
                answer.append(c); // 공백이나 다른 문자는 그대로 추가
            }
        }

        return answer.toString();
    }
}