import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] str=String.valueOf(n).split("");//문자 하나씩 str에 String타입으로 받기
        Arrays.sort(str);//오름차순 정렬 ["1", "2", "3", "4", "5"]
        
        StringBuilder sb=new StringBuilder();//문자열을 연결해줌 
        for(int i=0;i<str.length;i++){
            sb.append(str[i]);//문자 하나씩 넣기 "12345"
        }
        return Long.parseLong(sb.reverse().toString()); //"54321"
    }
}