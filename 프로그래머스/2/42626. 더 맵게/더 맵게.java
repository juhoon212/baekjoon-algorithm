import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        Arrays.stream(scoville)
                .boxed()
                .forEach(pq::add);

        int tryCount = 0;

        while (pq.size() > 1 && pq.peek() < K) {
            pq.add(pq.poll() + pq.remove() * 2);
            tryCount++;
        }


        return pq.peek() >= K ? tryCount : -1;
    }
}