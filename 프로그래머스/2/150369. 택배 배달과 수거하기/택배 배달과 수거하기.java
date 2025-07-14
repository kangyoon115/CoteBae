class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;// 총 이동 거리
        
        int d = 0;// 누적 배달량 (음수: 남은 배달량)
        int p = 0;// 누적 수거량 (음수: 남은 수거량)
        for(int i=n-1; i>=0; i--){
            d -= deliveries[i];
            p -= pickups[i];
            
            while(d < 0 || p < 0){
                d += cap;
                p += cap;
                answer += (i+1)*2;
            }
        }
        
        return answer;
    }
}