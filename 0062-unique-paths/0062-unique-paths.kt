class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val grid = Array(m) { IntArray(n) }
        // 행: n
        for (j in 0 until n) {
            grid[0][j] = 1
        }
        
        // 열: m
        for (i in 0 until m) {
            grid[i][0] = 1
        }

        // DP
        for (i: Int in 1 until m) {
            for (j: Int in 1 until n) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1]
            } 
        }
        return grid[m-1][n-1]
    }
}