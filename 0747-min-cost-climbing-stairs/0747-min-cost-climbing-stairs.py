class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        # 만약 두번째 index까지 올라간다 했을 때
        # min(index-1, index) 중에 최소를 구하면 된다.
        # 그러면 새로운 list를 만들어서 index-1 의 합을 저장해보자

        dp = [0] * len(cost)
        dp[0] = cost[0]
        dp[1] = cost[1]

        for i in range(2, len(cost)):
            dp[i] = min(dp[i-1]+cost[i], dp[i-2]+cost[i])
        return min(dp[len(cost)-1], dp[len(cost)-2])