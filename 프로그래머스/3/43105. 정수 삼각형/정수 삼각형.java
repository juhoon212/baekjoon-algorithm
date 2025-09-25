class Solution {
    public int solution(int[][] triangle) {
        int answer=0;
        // 대각선방향으로 우,왼 쪽으로 한칸만 이동가능
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length]; // 5x4
        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[0][0] + triangle[1][0];
        dp[1][1] = triangle[0][0] + triangle[1][1];
        
        for (int i=2; i<triangle.length; ++i) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            
            // 가운데 채우기
            for (int j=1; j<=i-1; ++j) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer;
    }
}