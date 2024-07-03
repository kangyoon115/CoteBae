//x를 String형태로 나누기
//String을 정수로 바꿔서 더하기
//그것을 x와 나눴을때 0이면 true 아니면 false
class Solution {
    public boolean solution(int num){
        String[] tmp=String.valueOf(num).split("");
        int sum=0;
        for(String s: tmp){
            sum+=Integer.parseInt(s);
        }if(num%sum==0){
            return true;
        }else{
            return false;
        }
    }
}

