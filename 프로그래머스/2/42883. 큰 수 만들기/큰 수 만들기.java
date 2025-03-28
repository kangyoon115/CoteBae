import java.util.*;

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            
            // 스택의 top보다 큰 숫자를 만나면 이전 숫자들 제거
            while (!stack.isEmpty() && k > 0 && stack.peek() < current) {
                stack.pop();
                k--;
            }
            
            stack.push(current);
        }
        
        // 아직 제거해야 할 숫자가 남았다면 뒤에서 제거
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // 스택의 내용을 결과 배열에 저장
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        
        return new String(result);
    }
}