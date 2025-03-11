import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // 파일명을 head, number, tail로 분리하여 정렬
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 파일명에서 head 추출 (숫자가 나오기 전까지의 문자열)
                String head1 = s1.split("[0-9]")[0].toLowerCase();
                String head2 = s2.split("[0-9]")[0].toLowerCase();
                
                // head 비교 (대소문자 구분 없이)
                int headCompare = head1.compareTo(head2);
                if (headCompare != 0) {
                    return headCompare;
                }
                
                // 숫자 부분(number) 추출
                String number1 = extractNumber(s1.substring(head1.length()));
                String number2 = extractNumber(s2.substring(head2.length()));
                
                // number 비교 (숫자값으로 비교)
                int num1 = Integer.parseInt(number1);
                int num2 = Integer.parseInt(number2);
                
                return Integer.compare(num1, num2);
            }
            
            // 문자열에서 연속된 숫자 부분만 추출하는 메서드
            private String extractNumber(String str) {
                StringBuilder sb = new StringBuilder();
                for (char c : str.toCharArray()) {
                    if (Character.isDigit(c) && sb.length() < 5) {
                        sb.append(c);
                    } else if (!Character.isDigit(c)) {
                        break;
                    }
                }
                return sb.toString();
            }
        });
        
        return files;
    }
}