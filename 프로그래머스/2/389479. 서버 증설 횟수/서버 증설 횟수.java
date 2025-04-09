class Solution {
    static int[] server;
    //사람 명수 m, 서버 지속 시간 k
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        server = new int[24];
        for(int i = 0; i < 24; i++){
            //현재 필요한 서버 수 계산
            int needServer = 0;
            if(players[i] >= m){
                if(players[i] % m == 0){
                    needServer += ((players[i] - m) / m) + 1;
                }
                else needServer += ((players[i] - m) / m) + 1;
            }
            
            //현재 가용가능한 서버 개수 구하기
            int serverCount = 0;
            for(int j = Math.max(0, i - k + 1); j < i; j++){
                serverCount += server[j];
            }
            
            //필요한 서버 수 계산
            int add = Math.max(0, needServer - serverCount);
            server[i] = add;
            answer += add;
            
        
        }
        return answer;
    }
}