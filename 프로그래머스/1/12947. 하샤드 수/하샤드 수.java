//x를 String형태로 나누기
//String을 정수로 바꿔서 더하기
//그것을 x와 나눴을때 0이면 true 아니면 false
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String[] s=String.valueOf(x).split("");
        int hap=0;
        
        for(int i=0;i<s.length;i++){
            hap+=Integer.parseInt(s[i]);
        }
        if(x%hap==0){
            answer=true;
        }else
            answer=false;
        return answer;
    }
}