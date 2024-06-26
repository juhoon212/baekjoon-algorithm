class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int size = cost.length;
        int dp[] = new int[size+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<size; i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[size-2],dp[size-1]);
    }
}