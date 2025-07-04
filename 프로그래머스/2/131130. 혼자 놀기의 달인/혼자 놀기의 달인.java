import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
          
        boolean[] visit = new boolean[cards.length+1];
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<cards.length;i++){
            
            if(visit[cards[i]]){
               continue; 
            }
            
            int current=cards[i];
            int count =0;
            
            while(true){
                             
                if(visit[current]){
                    break;
                }
                count++;
                
                visit[current]=true;
                
                current=cards[current-1];
            }
            
            list.add(count);          
        }
        
        if(list.size()<2){
            return 0;
        }
        
        Collections.sort(list,Collections.reverseOrder());
        
        answer=list.get(0)*list.get(1);
        
        return answer;
    }
}