class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int sum=0;
        for(int i=0;i<numbers.length;i++){
            sum+=numbers[i];
        }
        if(sum!=45){
                answer=45-sum;
            }
        return answer;
    }
}