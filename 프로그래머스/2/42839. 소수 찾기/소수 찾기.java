import java.util.*;

class Solution {
    HashSet<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        // 숫자 문자열을 문자 배열로 변환
        char[] arr = numbers.toCharArray();
        
        // 방문 여부를 체크하는 배열
        boolean[] visited = new boolean[arr.length];
        
        // 가능한 모든 길이(1~n)의 순열 생성
        for (int i = 1; i <= arr.length; i++) {
            // i는 순열의 길이
            permutation(arr, visited, "", i);
        }
        
        // 소수의 개수 세기
        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                count++;
            }
        }
        
        return count;
    }
    
    // 길이가 len인 모든 순열을 생성하는 재귀 함수
    private void permutation(char[] arr, boolean[] visited, String current, int len) {
        // 현재 순열의 길이가 목표 길이에 도달했을 때
        if (current.length() == len) {
            int num = Integer.parseInt(current);
            numberSet.add(num); // 중복을 제거하기 위해 Set 사용
            return;
        }
        
        // 모든 숫자에 대해 순회
        for (int i = 0; i < arr.length; i++) {
            // 아직 방문하지 않은 숫자라면
            if (!visited[i]) {
                visited[i] = true; // 방문 표시
                permutation(arr, visited, current + arr[i], len); // 재귀 호출
                visited[i] = false; // 방문 표시 해제 (백트래킹)
            }
        }
    }
    
    // 소수 판별 함수
    private boolean isPrime(int n) {
        // 0, 1은 소수가 아님
        if (n <= 1) {
            return false;
        }
        
        // 2, 3은 소수
        if (n <= 3) {
            return true;
        }
        
        // 2로 나누어 떨어지면 소수가 아님
        if (n % 2 == 0) {
            return false;
        }
        
        // 3부터 n의 제곱근까지의 홀수로 나누어 소수 판별
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}