import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input="";
        String output="";
        char ans;
        input=sc.nextLine();
        
        for(int i=0;i<input.length();i++){
            ans=input.charAt(i);
            if((65<=ans)&&(ans<=90)){
                output+=input.valueOf(ans).toLowerCase();
            }else if((97<=ans)&&(ans<=122)){
                output+=input.valueOf(ans).toUpperCase();
            }else{
                output+=(char)ans;
            }
        }
        System.out.println(output);
    }
}