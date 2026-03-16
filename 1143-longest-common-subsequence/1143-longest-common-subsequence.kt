class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        var t1 = text1.length
        var t2 = text2.length
        var dp: Array<Array<Int>> = Array(t1+1) { Array(t2+1) { 0 } }

        dp[t1-1][t2-1] = 1
        for (i in t1-1 downTo 0) {
            for (j in t2-1 downTo 0) {
                if (text1[i] == text2[j]) {
                    dp[i][j] = 1 + dp[i+1][j+1]
                } else {
                    dp[i][j] = maxOf(dp[i+1][j], dp[i][j+1])
                }
            }
        }
        return dp[0][0]
    }
}