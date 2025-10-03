import java.util.*;

class Solution {
    // info[i][0] = A도둑 흔적
    // info[i][1] = B도둑 흔적
    // 흔적은 1이상 3이하
    
    // n개이상 이면 A도둑은 붙잡힘
    // m개이상 이면 A도둑은 붙잡힘
    // 이때 A도둑이 남긴 흔적의 개수의 최솟값을 구하면됨.
    public int solution(int[][] info, int n, int m) {
        // 전에것을 계속 참고해야하므로 dp
        int[][] dp = new int[info.length+1][m];
        final int INF = 1000;
        
        for (int i=0; i<dp.length; ++i) Arrays.fill(dp[i], INF);
        dp[0][0] = 0; // ?
        
        // dp배열에 A의 최솟값을 계속 갱신해나가면서
        // 마지막 dp[info.length-1] 에 도달했을 시 최솟값을 구하면됨.
        // i는 index
        // j는 B가 훔친 물건의 갯수 합
        // dp[i][j] = A가 훔친 물건의 최소 수
        for (int i=1; i<info.length+1; ++i) {
            int a = info[i-1][0];
            int b = info[i-1][1];
            
            for (int j=0; j<m; ++j) {
                // A에게 흔적을 준 경우
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                // B에게 흔적을 준 경우
                if (j + b < m) dp[i][j+b] = Math.min(dp[i-1][j], dp[i][j+b]);
                System.out.println(dp[i][j] == INF ? "INF" : dp[i][j]);
            }
        }
        
        int answer=10000;
        for (int i=0; i<m; ++i) {
            answer = Math.min(answer, dp[info.length][i]);
        }
        
        return answer >= n ? -1 : answer;
    }
}