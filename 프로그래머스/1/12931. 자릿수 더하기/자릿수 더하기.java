import java.util.*;
// n을 charAt()으로 문자열을 하나씩 분리
// 그것을 배열에 저장한 뒤 그것을 for문으로 다 더하기
public class Solution {
    public int solution(int n) {
        int answer = 0;
        // 숫자를 문자열로 변환
        String str = Integer.toString(n);
        
        // 각 자리 숫자를 더하기
        for(int i = 0; i < str.length(); i++) {
            answer += Character.getNumericValue(str.charAt(i));
        }
        return answer;
    }
}