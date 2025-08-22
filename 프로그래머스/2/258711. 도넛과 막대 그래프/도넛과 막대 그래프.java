import java.util.*;

/*
    생성한 정점: 들어오는 간선0, 나가는 간선이 2개 이상
    도넛: 들어오는 간선1, 나가는 간선 1
    막대: 나가는 간선이 없음
    8자: 나가는 간선이 2개
*/

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        int[] answer = new int[4];

        for (int[] edge : edges) { // in, out 구분 저장
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }

        // out간선2개 이상중 in이 없으면 정점, 있으면 8자
        for (int node : out.keySet()) {
            if (out.get(node) > 1) { 
                if (!in.containsKey(node)) {
                    answer[0] = node;
                } else {
                    answer[3] += 1;
                }
            }
        }

        // in간선 중 out이 없으면 막대그래프 개수
        for (int node : in.keySet()) {
            if (!out.containsKey(node)) { 
                answer[2] += 1;
            }
        }
        // 도넛= 정점의out간선 수-막대그래프-8자 그래프
        answer[1] = out.get(answer[0]) - answer[2] - answer[3]; 
        return answer;
    }
}