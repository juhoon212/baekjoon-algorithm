class Solution {
    fun maxProfit(prices: IntArray): Int {
        var n: Int = prices.size
        
        var buy: Int = -prices[0]
        var sell: Int = 0
        var cooldown: Int = 0;
 
        for (i: Int in 1 until n) {
            val prevBuy = buy;
            val prevSell = sell;
            val prevCooldown = cooldown;

            // 오늘 사거나 전날에 팡아서 cooldown
            buy = maxOf(prevBuy, prevCooldown - prices[i])
            // 전날에 사서 파는것
            sell = prevBuy + prices[i]
            // 전날에 사서 or 판다음에 cooldown
            cooldown = maxOf(prevSell, prevCooldown)               
        }

        return maxOf(sell, cooldown)
    }
}