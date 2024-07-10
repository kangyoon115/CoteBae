import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int max_garo=0;
        int max_sero=0;
        
        for(int i=0;i<sizes.length;i++){
            int garo= Math.max(sizes[i][0],sizes[i][1]);
            int sero= Math.min(sizes[i][0],sizes[i][1]);
            max_garo=Math.max(max_garo,garo);
            max_sero=Math.max(max_sero,sero);
        }
        return max_garo*max_sero;
    }
}