class Solution {
      public int maxSubArray(int[] nums) {
        int cur[] = new int[nums.length];
        int total[] = new int[nums.length];

        Arrays.fill(cur, nums[0]);
        Arrays.fill(total, nums[0]);

        for (int i=1; i<nums.length; ++i) {
            cur[i] = Math.max(cur[i - 1] + nums[i], nums[i]);
            total[i] = Math.max(cur[i], total[i-1]);
        }

        return total[nums.length - 1];
    }
}