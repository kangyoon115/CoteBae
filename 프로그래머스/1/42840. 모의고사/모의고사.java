import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[] supoja1={1,2,3,4,5};
        int[] supoja2={2,1,2,3,2,4,2,5};
        int[] supoja3={3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==supoja1[i%supoja1.length])score[0]++;
            if(answers[i]==supoja2[i%supoja2.length])score[1]++;
            if(answers[i]==supoja3[i%supoja3.length])score[2]++;
        }
        
        int maxScore=Math.max(score[0],Math.max(score[1],score[2]));
        ArrayList<Integer> result=new ArrayList<>();
        if(score[0]==maxScore) result.add(1);
        if(score[1]==maxScore) result.add(2);
        if(score[2]==maxScore) result.add(3);
        
        int[] resultArray=new int[result.size()];
        for(int i=0;i<result.size();i++){
            resultArray[i]=result.get(i);
        }
        return resultArray;
    }
}