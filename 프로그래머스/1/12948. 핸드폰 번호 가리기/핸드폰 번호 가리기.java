import java.util.*;

class Solution {
    public String solution(String phone_number) {
        StringBuilder answer=new StringBuilder();
        
        //마지막 4자리 전까지 *로 변경
        int length=phone_number.length();
        for(int i=0;i<length-4;i++){
            answer.append("*");
        }
        //마지막 4자리는 그대로 answer에 담기
        answer.append(phone_number.substring(length-4));
        
        return answer.toString();
    }
}