import java.util.*;
class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        
        // 문자 배열을 정렬
        Arrays.sort(charArray);
        
        // 정렬된 배열을 역순으로 변환하여 새로운 문자열 생성
        StringBuilder answer = new StringBuilder(new String(charArray));
        
        // StringBuilder를 사용하여 역순으로 변환
        answer.reverse();
        
        return answer.toString();
    }
}