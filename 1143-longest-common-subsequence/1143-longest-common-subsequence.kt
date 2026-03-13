class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        // 2차원 배열 활용
        // dp 배열 선언
        val t1 = text1.length
        val t2 = text2.length
        val dp: Array<Array<Int>> = Array(t1+1) { Array(t2+1) { 0 } }

        for (i in t1-1 downTo 0) {
            for (j in t2-1 downTo 0) {
                if (text1[i] == text2[j]) {
                    dp[i][j] = dp[i+1][j+1] + 1
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1])
                }
            }
        }
        return dp[0][0]
    }
}