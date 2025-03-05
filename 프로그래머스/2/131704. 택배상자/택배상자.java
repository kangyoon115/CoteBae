import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> subBelt=new Stack<>();
        int boxIndex=1;//메인벨트에서 현재 처리할 상자 번호
        int orderIndex=0;//트럭에 실을 순서 인덱스
        int answer=0; //실은 상자 개수
        
        while(orderIndex<order.length){
            int targetbox=order[orderIndex];
            
            //현재 메인 벨트에 있는 상자가 목표상자인 경우
            if(boxIndex==targetbox){
                answer++;
                boxIndex++;
                orderIndex++;
            }
            
            //보조 벨트 위에 있는 상자가 목표상자인 경우
            else if(!subBelt.isEmpty() && subBelt.peek()==targetbox){
                subBelt.pop();
                answer++;
                orderIndex++;
            }
            //메인 벨트에서 보조벨트로 상자 이동
            else if(boxIndex<=order.length){
                subBelt.push(boxIndex);
                boxIndex++;
            }
            
            else{break;}
            
        }
        return answer;
    }
}