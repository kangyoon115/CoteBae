class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length()!=4&&s.length()!=6){
            answer=false;
        }
        for(int i=0;i<s.length();i++){
            int ascii=(int)s.charAt(i);
            if(ascii>=65){
                answer=false;
            }
        }
        return answer;
    }
}