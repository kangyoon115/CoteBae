import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n>0){
            if(n%2==1){ //점프
                ans++;
                n--;
            }else{
                n/=2; //순간이동
            }
        }
        return ans;
    }
}