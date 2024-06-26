import java.util.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> list=new ArrayList<>();
        
         // 주어진 numlist 배열을 순회하면서 n의 배수만 리스트에 추가
        for (int num : numlist) {
            if (num % n == 0) {
                list.add(num);
            }
        }
         // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}