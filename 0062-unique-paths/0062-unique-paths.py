class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        r = [1]*n

        for i in range(m-1):
            newR = [1]*n
            for j in range(n-2, -1, -1):
                newR[j] = newR[j+1] + r[j]
            r = newR
        
        return r[0]


