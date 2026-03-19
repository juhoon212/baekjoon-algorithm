func longestCommonSubsequence(text1 string, text2 string) int {
    t1 := len(text1)
    t2 := len(text2)

    dp := make([][]int, t1+1)
    for i:=0; i<t1+1; i++ {
        dp[i] = make([]int, t2+1)
    }

    for i:=t1-1; i>=0; i-- {
        for j:=t2-1; j>=0; j-- {
            if (text1[i] == text2[j]) {
                dp[i][j] = 1 + dp[i+1][j+1]
            } else {
                dp[i][j] = max(dp[i+1][j], dp[i][j+1])
            }
        } 
    }
    return dp[0][0] 
}