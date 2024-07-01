import java.util.*;

//String.valueOf(n);으로 string타입으로 형변환시킴
//for문으로 Integer.parseInt(s.substring())
//arrays.sort로 정렬한 후
class Solution {
    public int[] solution(long n) {
        String str=String.valueOf(n);
        int[] answer = new int[str.length()];
        
        for(int i=0;i<str.length();i++){
            answer[i]=Integer.parseInt(str.substring(answer.length-1-i,answer.length-i));
        }
        return answer;
    }
}