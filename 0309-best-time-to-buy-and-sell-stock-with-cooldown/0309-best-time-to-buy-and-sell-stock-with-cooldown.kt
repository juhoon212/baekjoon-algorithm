class Solution {
    fun maxProfit(prices: IntArray): Int {
        var n: Int = prices.size
        var buy: Int = -prices[0]
        var sell: Int = 0
        var cooldown: Int = 0

        for (i: Int in 1 until n) {
            var prevBuy = buy
            var prevSell = sell
            var prevCooldown = cooldown

            // 사는건 전날에 cooldown에서 
            buy = maxOf(prevCooldown - prices[i], prevBuy)
            sell = prevBuy + prices[i]
            cooldown = maxOf(prevSell, prevCooldown)
        } 
        return maxOf(sell, cooldown)
    }
}