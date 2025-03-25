import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 큐 생성
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        // 전체 합과 목표 합 계산
        long totalSum = 0;
        long sum1 = 0;
        long sum2 = 0;
        
        // 큐1에 원소 추가 및 합 계산
        for (int num : queue1) {
            q1.offer(num);
            sum1 += num;
            totalSum += num;
        }
        
        // 큐2에 원소 추가 및 합 계산
        for (int num : queue2) {
            q2.offer(num);
            sum2 += num;
            totalSum += num;
        }
        
        // 전체 합이 홀수면 불가능
        if (totalSum % 2 != 0) return -1;
        
        // 목표 합
        long target = totalSum / 2;
        
        // 제한 횟수
        int maxCount = (queue1.length + queue2.length) * 2;
        
        int count = 0;
        while (count < maxCount) {
            // 합이 같아지면 종료
            if (sum1 == sum2) return count;
            
            // sum1이 더 크면 q1에서 q2로 이동
            if (sum1 > sum2) {
                int num = q1.poll();
                q2.offer(num);
                sum1 -= num;
                sum2 += num;
            } 
            // sum2가 더 크면 q2에서 q1로 이동
            else {
                int num = q2.poll();
                q1.offer(num);
                sum2 -= num;
                sum1 += num;
            }
            
            count++;
        }
        
        // 제한 횟수 초과
        return -1;
    }
}