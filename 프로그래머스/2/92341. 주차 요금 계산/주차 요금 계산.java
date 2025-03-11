import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 기본 요금, 기본 시간(분), 단위 시간(분), 단위 요금
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        // 차량별 주차 시간을 기록할 맵
        Map<String, Integer> parkingTimes = new HashMap<>();
        
        // 현재 주차 중인 차량을 기록할 맵 (차량번호, 입차시간)
        Map<String, Integer> currentParking = new HashMap<>();
        
        // 모든 출입기록 처리
        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNumber = parts[1];
            String action = parts[2];
            
            int minutes = convertToMinutes(time);
            
            if (action.equals("IN")) {
                // 입차 기록
                currentParking.put(carNumber, minutes);
            } else {
                // 출차 기록
                int inTime = currentParking.get(carNumber);
                int parkingTime = minutes - inTime;
                
                // 주차 시간 누적
                parkingTimes.put(carNumber, parkingTimes.getOrDefault(carNumber, 0) + parkingTime);
                
                // 출차했으므로 현재 주차 목록에서 제거
                currentParking.remove(carNumber);
            }
        }
        
        // 출차 기록이 없는 차량은 23:59에 출차한 것으로 간주
        int endOfDay = convertToMinutes("23:59");
        for (String carNumber : currentParking.keySet()) {
            int inTime = currentParking.get(carNumber);
            int parkingTime = endOfDay - inTime;
            
            // 주차 시간 누적
            parkingTimes.put(carNumber, parkingTimes.getOrDefault(carNumber, 0) + parkingTime);
        }
        
        // 차량 번호 순으로 정렬하기 위해 TreeMap 사용
        Map<String, Integer> sortedParkingTimes = new TreeMap<>(parkingTimes);
        
        // 각 차량별 주차 요금 계산
        int[] answer = new int[sortedParkingTimes.size()];
        int index = 0;
        
        for (Map.Entry<String, Integer> entry : sortedParkingTimes.entrySet()) {
            int totalTime = entry.getValue();
            int fee = basicFee;
            
            // 기본 시간을 초과한 경우 추가 요금 계산
            if (totalTime > basicTime) {
                int extraTime = totalTime - basicTime;
                // 올림 처리를 위한 계산
                int extraFee = (int) Math.ceil((double) extraTime / unitTime) * unitFee;
                fee += extraFee;
            }
            
            answer[index++] = fee;
        }
        
        return answer;
    }
    
    // HH:MM 형식의 시간을 분 단위로 변환하는 함수
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}