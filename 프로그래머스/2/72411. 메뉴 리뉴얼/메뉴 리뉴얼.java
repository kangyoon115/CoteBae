import java.util.*;

class Solution {
    static HashMap<String,Integer> map; // 조합 문자열 -> 빈도수 저장

    // 조합 생성 (str: 메뉴 문자열, sb: 조합 저장, idx: 시작 인덱스, cnt: 현재 조합 길이, n: 목표 조합 길이)
    public static void combi(String str, StringBuilder sb, int idx, int cnt, int n) {
        if(cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for(int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            combi(str, sb, i + 1, cnt + 1, n);
            sb.delete(cnt, cnt + 1); // 백트래킹
        }
    }

    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        // 주문 문자열 정렬 (조합을 일정하게 만들기 위함)
        for(int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        // 각 코스 요리 길이마다 조합 처리
        for(int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;

            for(int j = 0; j < orders.length; j++) {
                if(course[i] <= orders[j].length())
                    combi(orders[j], new StringBuilder(), 0, 0, course[i]);
            }

            // 최대 빈도 찾기
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            // 2명 이상이 주문했고 최대 빈도인 조합만 선택
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(max >= 2 && entry.getValue() == max)
                    answer.add(entry.getKey());
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
