//세균 1시간마다 ^2
//세균 n마리와 경과한 시간 t
//n+t^2
class Solution {
    public int solution(int n, int t) {
        int answer = n;
        
        for(int i=0;i<t;i++){
            answer*=2;
        }
        return answer;
    }
}