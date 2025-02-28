import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        
        for(int value: scoville){
            heap.offer(value);
        }
        
        int count=0;
        
        //가장 맵지 않은 음식의 스코빌 지수가 K보다 작은 동안 반복
        while(heap.size()>=2&& heap.peek()<K){
            int least=heap.poll();
            int secondleast=heap.poll();
            
            int newScoville = least+(secondleast*2);
            heap.offer(newScoville);
            
            count++;
        }
        
        if(heap.peek()<K){
            return -1;
        }
        
        return count;
    }
}