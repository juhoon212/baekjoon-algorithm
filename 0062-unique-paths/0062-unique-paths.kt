class Solution {
    lateinit var memo: Array<IntArray>
    fun uniquePaths(m: Int, n: Int): Int {
        memo = Array(m) { IntArray(n) { -1 } }
        return dfs(m-1, n-1)
    }

    fun dfs(i: Int, j: Int): Int {
        if (i == 0 || j == 0) return 1
        if (memo[i][j] != -1) return memo[i][j]

        memo[i][j] = dfs(i-1, j) + dfs(i, j-1)
        return memo[i][j]
    }
}