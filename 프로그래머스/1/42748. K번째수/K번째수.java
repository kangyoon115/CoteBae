import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer=new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int k=commands[i][0];
            int j=commands[i][1];
            int z=commands[i][2];
            
        int[] SliceArray= Arrays.copyOfRange(array,k-1,j);
        Arrays.sort(SliceArray);
        answer[i]=SliceArray[z-1];
        
        }
        return answer;
    }
}