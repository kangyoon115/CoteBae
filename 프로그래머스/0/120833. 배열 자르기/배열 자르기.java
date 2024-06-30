import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=num1;i<=num2;i++){
            list.add(numbers[i]);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}