// signs의 값에 따라 absolutes의 부호 결정 그다음에 합 계산
// if(signs==true) +  elseif(signs==false) -
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0;i<absolutes.length;i++){
            if(signs[i]==true){
                answer+=absolutes[i];
            }else{
                answer-=absolutes[i];
            }
        }
        return answer;
    }
}