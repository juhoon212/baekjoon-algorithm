class Solution {

    static Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
         // bottom up

        map.put(1, 1);
        map.put(2, 2);

        for (int i = 3; i < n + 1; i++) {
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }

        return map.get(n);
    }
}