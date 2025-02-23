class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        memo_length = len(cost)+1
        memo = [0] * memo_length
        memo[0] = cost[0]
        memo[1] = cost[1]

        for i in range(2, memo_length-1):
            memo[i] = min(memo[i-1], memo[i-2]) + cost[i]
        return min(memo[len(cost)-1], memo[len(cost)-2])
