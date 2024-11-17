class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int carpet=brown+yellow;
        
        //yellow가 존재하려면 가로세로가 각각3이상
        for(int i=3;i<=carpet;i++){
            int sero=i;
            int garo=carpet/sero;
            
            if(garo<3){
                continue;
            }
            
            if(garo>=sero){
                if((garo-2)*(sero-2)==yellow){
                    answer[0]=garo;
                    answer[1]=sero;
                    break;
                }
            }
        }
        
        return answer;
    }
}