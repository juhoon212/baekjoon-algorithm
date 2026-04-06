class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val n: Int = coins.size
        val dp: Array<IntArray> = Array(n+1) { IntArray(amount+1) { 0 } }
        
        // amount가 0일때는 1가지이므로 초기값 세팅
        for (i: Int in 0 .. n) {
            dp[i][0] = 1
        }

        for (i: Int in 1 .. n) {
            for (j: Int in 1 .. amount) {
                if (j >= coins[i-1]) {
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j]
                } else {
                    dp[i][j] = dp[i-1][j]
                }
            }
        }
        return dp[n][amount]
    }
}