import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 유저 아이디와 닉네임을 저장할 맵
        Map<String, String> userMap = new HashMap<>();
        // 최종 메시지를 저장할 리스트
        List<String> messageList = new ArrayList<>();
        // 메시지 생성에 필요한 정보를 저장할 임시 리스트
        List<String[]> actionList = new ArrayList<>();
        
        // 기록을 순회하며 유저 정보와 액션 정보 수집
        for (String rec : record) {
            String[] parts = rec.split(" ");
            String action = parts[0];
            String userId = parts[1];
            
            // Enter나 Change 액션이면 유저 닉네임 업데이트
            if ("Enter".equals(action) || "Change".equals(action)) {
                String nickname = parts[2];
                userMap.put(userId, nickname);
            }
            
            // Enter나 Leave 액션이면 메시지 생성을 위한 정보 저장
            if ("Enter".equals(action) || "Leave".equals(action)) {
                actionList.add(new String[]{action, userId});
            }
        }
        
        // 액션 리스트를 순회하며 최종 메시지 생성
        for (String[] actionInfo : actionList) {
            String action = actionInfo[0];
            String userId = actionInfo[1];
            String nickname = userMap.get(userId);
            
            if ("Enter".equals(action)) {
                messageList.add(nickname + "님이 들어왔습니다.");
            } else if ("Leave".equals(action)) {
                messageList.add(nickname + "님이 나갔습니다.");
            }
        }
        
        // 리스트를 배열로 변환하여 반환
        return messageList.toArray(new String[0]);
    }
}