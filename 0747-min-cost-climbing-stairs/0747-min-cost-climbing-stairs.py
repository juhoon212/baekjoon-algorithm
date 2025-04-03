class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        # 비용을 지불하면 1단계 혹은 2단계 까지 올라갈 수 있다.
        # result[i] = min(result[i-1], result[i-2])

        memo = [0]* (len(cost)+1)

        for i in range(2, len(cost)+1):
            memo[i] = min(memo[i-1]+cost[i-1], memo[i-2] + cost[i-2])

        return memo[len(cost)]