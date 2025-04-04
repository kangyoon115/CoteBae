class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int digit = storey % 10;
            
            // 다음 자릿수(십의 자리) 확인
            int nextDigit = (storey / 10) % 10;
            
            if (digit < 5) {
                // 5보다 작으면 내림
                answer += digit;
            } else if (digit > 5) {
                // 5보다 크면 올림
                answer += (10 - digit);
                storey += 10; // 다음 자릿수에 1 추가
            } else { // digit == 5
                // 5일 경우, 다음 자릿수에 따라 결정
                if (nextDigit >= 5) {
                    // 다음 자릿수가 5 이상이면 올림이 유리
                    answer += (10 - digit);
                    storey += 10;
                } else {
                    // 다음 자릿수가 5 미만이면 내림이 유리
                    answer += digit;
                }
            }
            
            // 다음 자릿수로 이동
            storey /= 10;
        }
        
        return answer;
    }
}