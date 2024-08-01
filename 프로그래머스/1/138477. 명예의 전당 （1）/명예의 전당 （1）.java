import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
      // 명예의 전당에서 최하위 점수를 저장할 리스트 생성
        List<Integer> answerList = new ArrayList<>();
        // 명예의 전당을 관리할 우선순위 큐 (최소 힙)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 점수를 하나씩 확인
        for (int i = 0; i < score.length; i++) {
            // 새로운 점수를 우선순위 큐에 추가
            pq.offer(score[i]);

            // 만약 큐의 크기가 k보다 크다면, 최하위 요소를 제거
            if (pq.size() > k) {
                pq.poll();
            }

            // 현재 명예의 전당에서 최하위 점수를 리스트에 추가
            answerList.add(pq.peek());
        }

        // 리스트를 배열로 변환하여 반환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }


        return answer;
    }
}