import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        char[] carr=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<carr.length;i++){
            char c=carr[i];
            //스택이 비어있다면 넣기
            if(stack.isEmpty()) stack.push(c);
            //스택이 비어있지않다면 
            else {
                //가장 위에가 c랑 같다면 pop
                if(stack.peek()==c){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}