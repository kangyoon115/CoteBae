class Solution{
   public int[] solution(int[] array){
     int[] answer=new int[2];//answer[0]: 가장 큰값 answer[1]: 해당 인덱스값
       for(int i=0;i<array.length;i++){ //array의 모든 값을 하나씩 검열
           if(array[i]>answer[0]){ 
               //만약 array[i]에 들어있는 값이 다음 array[0]의 값보다 크다면 answer[0]에 담기
               answer[0]=array[i];
               answer[1]=i;
           }
       }
      return answer;
   }
}