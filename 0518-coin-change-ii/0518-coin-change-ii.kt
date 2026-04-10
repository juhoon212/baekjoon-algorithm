class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val dp: IntArray = IntArray(amount+1) { 0 }
        var index: Int = 0

        dp[0] = 1
        while (index < coins.size) {
            for (i: Int in 1 .. amount) {
                if (coins[index] <= i) {
                    dp[i] += dp[i - coins[index]]
                }
            }
            index += 1
        }
        return dp[amount]
    }
}