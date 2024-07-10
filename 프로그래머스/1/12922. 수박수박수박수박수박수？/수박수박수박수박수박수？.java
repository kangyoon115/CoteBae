class Solution {
    public String solution(int n) {
        String pattern="수박";
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<n;i++){
            sb.append(pattern);
        }
        
        return sb.substring(0, n);
    }
}