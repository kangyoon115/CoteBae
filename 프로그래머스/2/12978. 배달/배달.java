import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 도로 추가
        for (int[] r : road) {
            int a = r[0], b = r[1], t = r[2];
            graph.get(a).add(new int[]{b, t});
            graph.get(b).add(new int[]{a, t});
        }

        // 거리 배열 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        // 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0}); // 시작점

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int time = cur[1];

            if (time > dist[now]) continue;

            for (int[] next : graph.get(now)) {
                int nextNode = next[0];
                int cost = next[1];
                if (dist[nextNode] > dist[now] + cost) {
                    dist[nextNode] = dist[now] + cost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        // K 이하 시간에 도달 가능한 마을 개수 세기
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }

        return count;
    }
}
