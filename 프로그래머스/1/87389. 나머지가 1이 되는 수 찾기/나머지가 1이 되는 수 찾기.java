//자연수 n 10 10을 x로 나눈 나머지가 1이 되도록 10%x==1
//여기서 x가 가장 작은 자연수여야 한다
import java.util.*;
class Solution {
    public int solution(int n) {
        int answer=0;
        for(int i=2;i<n;i++){
            if(n%i==1){
                answer=i;
                break;
            }
        }
        return answer;
}
}