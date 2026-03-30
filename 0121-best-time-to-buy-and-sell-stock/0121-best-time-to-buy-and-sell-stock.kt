class Solution {
    fun maxProfit(prices: IntArray): Int {
        var n: Int = prices.size

        var profit: Int = 0
        var buy = 0
        for (i: Int in 1 until n) {
            if (prices[buy] > prices[i]) buy = i
            profit = maxOf(profit, prices[i] - prices[buy])
        }
        return profit
    }
}