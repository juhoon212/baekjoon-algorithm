import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 물품 수
        int k = Integer.parseInt(st.nextToken()); // 견딜 수 있는 무게
        
        int[][] dp = new int[n+1][k+1];
        for (int i=1; i<n+1; ++i) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 무게
            int v = Integer.parseInt(st.nextToken()); // 가치
            
            for (int j=0; j<=k; ++j) {
                dp[i][j] = dp[i-1][j]; // 
                if (j >= w) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w] + v);
            }
        }
        
        System.out.println(dp[n][k]);
    }
}