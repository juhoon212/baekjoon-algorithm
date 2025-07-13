import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        // 대문자 2차원 배열 생성
        int n = storage.length;
        int m = storage[0].length();
        
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};
        
        int[][] map = new int[n][m];
        
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                map[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        
        for (String request : requests) {
            int target = request.charAt(0) - 'A';
            
            // 크레인
            if (request.length() == 2) {
                for (int i=0; i<n; ++i) {
                    for (int j=0; j<m; ++j) {
                        if (map[i][j] == target) map[i][j] = -1;
                        continue;
                    } 
                }
            }
            
            // 지게차
            int[][] memo = new int[n][m];
            final int INF = 10000001;
            for (int i=0; i<n; ++i) {
                Arrays.fill(memo[i], INF);
            }
            
            Queue<int[]> q = new ArrayDeque<>();
            
            for (int i=0; i<n; ++i) {
                for (int j=0; j<m; ++j) {
                    if (i != 0 && j != 0 && i < n-1 && j < m-1) continue;
                    if (map[i][j] == -1) {
                        memo[i][j] = 0;
                        q.add(new int[]{i, j});
                    } else {
                        memo[i][j] = 1;
                        if (map[i][j] == target) map[i][j] = -1;
                    }
                }
            }
            
            while (!q.isEmpty()) {
                int[] now = q.poll();
                
                for (int i=0; i<4; ++i) {
                    int nextX = now[0] + dx[i];
                    int nextY = now[1] + dy[i];
                    
                    if (!validate(n, m, nextX, nextY) || memo[nextX][nextY] != INF) continue;
                    
                    if (map[nextX][nextY] == -1) {
                        memo[nextX][nextY] = 0;
                        q.add(new int[]{nextX, nextY});
                    } else {
                        memo[nextX][nextY] = 1;
                        if (map[nextX][nextY] == target) map[nextX][nextY] = -1;
                    }
                }
            }
        }
        
        // 살아남은 박스 개수 세기
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (map[i][j] != -1) answer++;

        return answer;
    }
    
    boolean validate(int n, int m, int x, int y) {
        if (x < 0 || x > n-1 || y < 0 || y > m-1) return false;
        return true;
    }
}
