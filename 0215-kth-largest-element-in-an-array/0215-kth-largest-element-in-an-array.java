class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums) {
            pq.add(num);
        }
        int count = 0;
        while (count != k) {
            int result = pq.poll();
            count++;

            if (count == k) {
                return result;
            }
        }

        return count;
    }
}