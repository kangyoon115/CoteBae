import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //현재다리 위 트럭 관리
        Queue<Integer> bridgeQ=new LinkedList<>();
        
        //다리 위 트럭 무게 합
        int currentWeight =0;
        
        //총 경과 시간
        int time=0;
        
        //트럭 인덱스
        int truckIndex=0;
        
        while(truckIndex<truck_weights.length){
            time++;
            
            //다리 큐의 길이가 다리 길이와 같으면 맨 앞 트럭 제거
            if(bridgeQ.size()==bridge_length){
                currentWeight-=bridgeQ.poll();
            }
            //다음 트럭이 다리에 올라갈수있는지 확인
            if(currentWeight+truck_weights[truckIndex]<=weight){
                bridgeQ.offer(truck_weights[truckIndex]);
                currentWeight+= truck_weights[truckIndex];
                truckIndex++;
            }else{
                //무게 초과 시 더미트럭0을 삽입해 트럭 유지
                bridgeQ.offer(0);
            }
        }
        
        return time+bridge_length;
    }
}