//x를 배열로 가져오기
//x를 n만큼 늘리면서 저장하기
import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        ArrayList<Long> list=new ArrayList<>();
        
        for(int i=1;i<=n;i++){
           list.add((long)i*x);
        }
        long[] answer = new long[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]+=list.get(i);
        }
        return answer;
    }
}