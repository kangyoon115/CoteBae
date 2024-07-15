class Solution {
    public int[] solution(int n, int m) {
        int chede=1;
        int cheso=n*m;
        
        for(int i=1;i<=Math.min(n,m);i++){
            if(n%i==0&&m%i==0){
                chede=i;
            }
        }
        cheso=(n*m)/chede;
        int[] answer={chede,cheso};
        return answer;
    }
}