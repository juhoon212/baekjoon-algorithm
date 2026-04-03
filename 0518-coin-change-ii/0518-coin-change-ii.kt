class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val n: Int = coins.size
        val m: Int = amount
        val dp: Array<IntArray> = Array(n+1) { IntArray(m+1) }
        
        // 125 row, col 0 1 2 3 4 5
        for (i in 0 .. n) {
            dp[i][0] = 1;
        }

        for (i: Int in 1 .. n) {
            for (j: Int in 1 .. amount) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j]
                }
            }
        }
        return dp[n][amount]
    }
}