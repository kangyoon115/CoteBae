import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String s) {
            // 1. 영단어와 숫자의 매핑 정의
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        // 2. 문자열에서 영단어 찾기 및 대체
        for (Map.Entry<String, String> entry : map.entrySet()) {
            s = s.replaceAll(entry.getKey(), entry.getValue());
        }

        // 3. 변환된 문자열을 숫자로 변환
        return Integer.parseInt(s);
    }
}