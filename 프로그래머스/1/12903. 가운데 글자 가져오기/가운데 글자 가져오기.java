class Solution {
    public String solution(String s) {
        int mid=s.length()/2;
        
        //길이가 홀수일 때
        if(s.length()%2==1){
            return String.valueOf(s.charAt(mid));
        }
        //길이가 짝수일 때
        else 
            return s.substring(mid-1,mid+1);
    }
}