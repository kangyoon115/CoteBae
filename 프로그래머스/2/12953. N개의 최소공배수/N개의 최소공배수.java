class Solution {
    //최대공약수
        private static int gcd(int a, int b){
            int r=a%b;
            if(r==0) return b;
            else return gcd(b,r);
        }
    
    public int solution(int[] arr) {
        //유클리드 호제법
        //최소공배수=두수의 곱/최대공약수
        int answer = 0;
    
        
        if(arr.length==1) return arr[0]; //원소 1개면 바로 출력
        
        int g = gcd(arr[0],arr[1]); //처음 두수의 최대공약수
        answer=(arr[0]*arr[1])/g; //처음 두수의 최소공배수
        
        
        if(arr.length>2){
            for(int i=2;i<arr.length;i++){
                g=gcd(answer,arr[i]);
                answer=(answer*arr[i])/g;
            }
        }
        return answer;
    }
    
    
    
}