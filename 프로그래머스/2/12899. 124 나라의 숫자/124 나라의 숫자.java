class Solution {
  public String solution(int n) {
      String[] numbers = {"4", "1", "2"}; // 0->4, 1->1, 2->2
      String answer = "";
      
      int num = n;
      
      while(num > 0){
          int remainder = num % 3;
          num /= 3;
          
          if(remainder == 0) num--; //3 대신 4이므로 -1
          
          answer = numbers[remainder] + answer;
      }
      
      return answer;
  }
}