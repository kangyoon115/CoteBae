import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1){//배열에 값이 한개일경우 -1 출력
            return new int[]{-1};
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){//배열을 리스트 형태로 변환
            list.add(arr[i]);
        }
        int minIndex=0;
        for(int i=0;i<list.size();i++){ //가장 작은 수 찾기
            if(list.get(i)<list.get(minIndex))
                minIndex=i;
        }
        list.remove(minIndex); //가장 작은 수 제거
        int[] answer = new int[list.size()]; //정답을 출력할 answer함수 정의
        
        for(int i=0;i<list.size();i++){ //리스트를 배열로 변환
            answer[i]=list.get(i);
        }
        return answer;
    }
}