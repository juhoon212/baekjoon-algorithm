class Solution {
    fun maxProfit(prices: IntArray): Int {
        // init
        var l: Int = 0
        var profit: Int = 0

        for (r: Int in 1 until prices.size) {
            if (l >= prices.size) break;
            if (prices[l] < prices[r]) {
                profit = maxOf(profit, prices[r] - prices[l])
            } else l = r;
        }
        return profit
    }
}