import java.util.*;

class Solution {
    // A 도둑, B도둑 모두 흔적을 최소화해야 함.
    // 물건 훔치는 조건은
    // A도둑 흔적 info[i][0]
    // B도둑 흔적 info[i][1]
    // A도둑이 남긴 흔적의 누적 개수 최솟값 구해라
    // 전에껄 참고해야되니 dp 문제
    public int solution(int[][] info, int n, int m) {
        // B가 물건을 많이 훔칠수록 좋다.
        // dp[][] 에서 첫번째 배열의 크기는 info의 index,
        // 두번째 배열은 b가 훔친 물건의 갯수
        // dp[][] = A가 훔친 물건의 최소 갯수
        // 불확실 조건일때는 해당 칸을 INF로 명시
        int INF = 10000;
        
        int size = info.length+1;
        int[][] dp = new int[size][m];
        // dp 배열 초기화
        for (int i=0; i<size; ++i) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        
        for (int i=1; i<size; ++i) {
            int a = info[i-1][0];
            int b = info[i-1][1];
            
            for (int j=0; j<m; ++j) {
                // a가 훔쳤을 때
                dp[i][j] = Math.min(dp[i-1][j] + a, dp[i][j]);
                // b가 훔쳤을 때
                if (j + b < m) {
                    dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]);
                }
            }
        }
        
        int answer=INF;
        for (int i=0; i<m; ++i) {
            answer = Math.min(answer, dp[size-1][i]);
        }
        return answer >= n ? -1 : answer;
    }
}