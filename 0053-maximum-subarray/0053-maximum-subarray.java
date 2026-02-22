class Solution {
      public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        // Step 1: Create DP array
        int[] dp = new int[n];
        
        // Step 2: Base case
        dp[0] = nums[0];
        
        // Step 3: Fill DP table
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        
        // Step 4: Find global maximum
        int maxSum = dp[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        
        return maxSum;
      }
}