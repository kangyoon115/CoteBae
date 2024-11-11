class Solution {
    public int solution(int n) {
        int answer = 0;
        String str=Integer.toBinaryString(n); //2진수 변환
        int cnt=0; //n의 1 비트 수 저장
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')cnt++;//n의 1의 비트 총 갯수 
        }
        
        for(int i=n+1;i<1000000;i++){
            String str2=Integer.toBinaryString(i);
            int str2_cnt=0;
            for(int j=0;j<str2.length();j++){
                if(str2.charAt(j)=='1')str2_cnt++;
            }
            if(str2_cnt==cnt){
                answer=i;
                break;

            }
        }
        return answer;
    }
}