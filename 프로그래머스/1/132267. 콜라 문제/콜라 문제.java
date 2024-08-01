// a개의 콜라빈병 , b 콜라 주는 개수 , n 상빈이 가지고 있는 빈병의 개수
class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(true){
            
            if(n<a){
                break;
            }
            answer+=(n/a)*b;
            n=((n/a)*b)+(n%a);
        }
        return answer;
    }
}