import java.util.*;

class Solution {
    public int[] solution(String[] arguments) {
        int[] answer = {0,0};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<>(Collections.reverseOrder());

        for (String arg : arguments) {
            String[] temp = arg.split(" ");
            if (temp[0].equals("I")) {
                int num = Integer.parseInt(temp[1]);
                pq.add(num);
                reverse_pq.add(num);
            } else { // "D"
                if (!pq.isEmpty()) {
                    int op = Integer.parseInt(temp[1]);
                    if (op == 1) {
                        int max = reverse_pq.poll();
                        pq.remove(max);
                    } else {
                        int min = pq.poll();
                        reverse_pq.remove(min);
                    }
                }
            }
        }

        if (pq.isEmpty()) {
            return answer; // {0,0}
        } else if (pq.size() == 1) {
            int val = pq.peek();
            answer[0] = val;
            answer[1] = val;
        } else {
            answer[0] = reverse_pq.poll();
            answer[1] = pq.poll();
        }

        return answer;
    }
}
