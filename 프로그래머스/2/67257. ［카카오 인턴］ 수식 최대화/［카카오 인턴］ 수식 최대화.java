import java.util.*;
 
class Solution {
    static long MAX = 0;
    static List<Long> numList = new ArrayList<>();//숫자 리스트[100,200,300,500,20]
    static List<Character> optList = new ArrayList<>();//연산자 리스트(순서 있음)[-,*,-,+]
    static List<Character> optKind = new ArrayList<>();//연산자 종류 리스트(순열용)[-,*,+]
    static boolean[] visit;
 
    public static long solution(String expression) {
        splitExp(expression);//숫자,연산자 리스트 추출
 
        visit = new boolean[optKind.size()];
        List<Character> order = new ArrayList<>();
        priorityOrder(order);//우선순위 조합 만들며 계산 
        
        return MAX;//최대값 반환
    }
    
    // 숫자와 연산자를 분리
    private static void splitExp(String exp) {
        char[] arr = exp.toCharArray();
        Set<Character> optSet = new HashSet<>();
        StringBuilder numberStr = new StringBuilder();
        
        for (char c : arr) {
            if (c == '+' || c == '-' || c == '*') {
                optSet.add(c);//연산자 종류
                optList.add(c);//순서대로 저장
                numList.add(Long.valueOf(numberStr.toString()));//숫자 저장
                numberStr = new StringBuilder();//초기화
            } else {
                numberStr.append(c);
            }
        }
        numList.add(Long.valueOf(numberStr.toString()));
        optKind = new ArrayList<>(optSet);
    }    
    
    // 연산자의 우선순위 구하기
    private static void priorityOrder(List<Character> order) {
        if (order.size() == optKind.size()) {
            // 정해진 우선순위에 맞게 계산
            Long now = calc(order);
            if(now>MAX)MAX=now; //최대값 갱신
            return;
        }
        
        for (int i = 0; i < optKind.size(); i++) {
            if (visit[i]) continue;
            visit[i] = true;
            order.add(optKind.get(i));
            priorityOrder(order);
            visit[i] = false;
            order.remove(order.size() - 1);
        }
    }
 
    private static Long calcOpt(long a, long b, char opt) {
        long res = 0;
        if (opt == '+') {
            res = a + b;
        } else if (opt == '-') {
            res = a - b;
        } else {
            res = a * b;
        }
        return res;
    }
    
    // 연산자의 우선순위에 맞춰 계산
    private static Long calc(List<Character> order) {
        List<Long> copyNumList = new ArrayList<>(numList); //숫자카피
        List<Character> copyOptList = new ArrayList<>(optList); //연산자카피
 
        for (char opt : order) {
            for (int i = 0; i < copyOptList.size(); i++) {
                if (opt == copyOptList.get(i)) {
                    // 앞 숫자와 다음 숫자 연산 → 결과를 i에 덮어쓰기
                    copyNumList.set(i, calcOpt(copyNumList.get(i), copyNumList.get(i + 1), opt));
                    copyNumList.remove(i + 1);// 사용된 숫자 제거
                    copyOptList.remove(i);// 사용된 연산자 제거
                    i--;
                }
            }
        }
        return Math.abs(copyNumList.get(0));
    }
}