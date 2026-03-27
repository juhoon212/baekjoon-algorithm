class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buy: Int = 0
        var profit: Int = 0
        for (i: Int in 1 until prices.size) {
            if (prices[i] < prices[buy]) buy = i
            else profit = maxOf(profit, prices[i] - prices[buy])
        }
        return profit
    }
}