//
class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(int i=0;i<s1.length;i++){
            for(int j=0;j<s2.length;j++){
            //각 배열의 해당 인덱스에 접근하여 비교
            //길이가 짧은 배열의 경우 배열범위를 벗어나지 않도록 주의
            if(s1[i].equals(s2[j])){
                answer++;
            }
            }
            
        }
        return answer;
    }
}