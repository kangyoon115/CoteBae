import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList();
        int num = 27;
        char ch = 'A';
        
        // 사전에 영문자, 색인번호 추가
        for(int i=1;i<=26;i++) {
            map.put(String.valueOf(ch), i);
            ch++;
        }
        int cnt = 0;
        
        // A - 26
        for(int i = 0; i<msg.length(); i++){
            String tmp = "";
            int check = 0;
            if(cnt > 0){
                cnt--;
                continue;
            }
            for(int j = i; j<msg.length(); j++){
                tmp += msg.substring(j, j+1);
                           
                // 마지막 체크
                if(j == msg.length() - 1 && map.containsKey(tmp)){
                    list.add(map.get(tmp));
                    check = 1;
                    break;
                }
                
                if(map.containsKey(tmp)){
                    continue;
                }else{
                    map.put(tmp, num++);
                    list.add(map.get(tmp.substring(0, tmp.length()-1)));                
                    cnt = tmp.length()-2;
                    break;
                }
            }
            
            if(check == 1) break;
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}