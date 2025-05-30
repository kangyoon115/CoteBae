class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        long x = (long)w;
        long y = (long)h;
        
        for(int i=1;i<w;i++){
            answer += y*i/x ; // y=12/8x, x=1-> y=12*1/8
        }
        
        return answer*2;
    }
}