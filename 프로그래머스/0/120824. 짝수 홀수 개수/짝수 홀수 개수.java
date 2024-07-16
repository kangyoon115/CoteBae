class Solution {
    public int[] solution(int[] num_list) {
        int jack=0;
        int hol=0;
        int[] answer=new int[2];
        for(int i=0;i<num_list.length;i++){
            if(num_list[i]%2==0){
                jack++;
            }else
                hol++;
        }        
        answer[0]=jack;
        answer[1]=hol;
        
        return answer;
    }
}