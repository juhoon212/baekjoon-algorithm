class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i=0; i<nums.length; ++i) {
            for (int j=0; j<i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
        
    }
}