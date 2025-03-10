class Solution:
    def climbStairs(self, n: int) -> int:
        memo = [0] * 46

        if n == 1:
            return 1
        
        if n == 2:
            return 2

        memo[1] = 1
        memo[2] = 2

        for i in range(3, n+1):
            memo[i] = memo[i-1] + memo[i-2]
        
        return memo[n]
        