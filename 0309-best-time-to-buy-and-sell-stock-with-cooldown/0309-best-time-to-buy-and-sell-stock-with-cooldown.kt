class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n: Int = prices.size;

        // 전날 내가 주식을 샀는지 팔았는지 cooldown 상태인지 알아야 함 -> dp
        var buy: Int = -prices[0]
        var sell: Int = 0
        var cooldown: Int = 0

        for (i in 1 until n) {
            val prevBuy = buy;
            val prevSell = sell;
            val prevCooldown = cooldown;

            buy = maxOf(prevBuy, prevCooldown - prices[i]) // 전날 샀거나, 전날 cooldown 상태에서 새로삼
            sell = prevBuy + prices[i]
            cooldown = maxOf(prevSell, prevCooldown) // 전날에 팔아서 cooldown 상태, 계속 cooldown 상태인경우
        }

        return maxOf(sell, cooldown)
    }
}