import java.util.*;

class Solution {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, -1, 0, 1};
    
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        
        int[][] map = new int[n][m];
        int result = 0;
        
        // map 세팅
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                map[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        
        for (String request : requests) {
            int target = request.charAt(0) - 'A';
            
            // -1은 지워짐, 0은 
            // 크레인
            if (request.length() == 2) {
                for (int i=0; i<n; ++i) {
                    for (int j=0; j<m; ++j) {
                        if (map[i][j] == target) map[i][j] = -1;
                    }
                }
                continue;
            }
            
            int[][] memo = new int[n][m];
            // memo 배열 채우기
            final int INF = 10000001;
            for (int i=0; i<n; ++i) {
                Arrays.fill(memo[i], INF);
            }
            
            Queue<int[]> q = new ArrayDeque<>();
            for (int i=0; i<n; ++i) {
                for (int j=0; j<m; ++j) {
                    if (i != 0 && j != 0 && i<n-1 && j<m-1) continue;
                    if (map[i][j] == -1) {
                        memo[i][j] = 0;
                        q.add(new int[]{i, j});
                    } else {
                        memo[i][j] = 1; // 갈수 없는 공간
                        if (map[i][j] == target) map[i][j] = -1;
                    }
                }
            }
            
            while (!q.isEmpty()) {
                int[] now = q.poll();
                
                for (int i=0; i<4; ++i) {
                    int nextX = dx[i] + now[0];
                    int nextY = dy[i] + now[1];
                    
                    if (!validate(nextX, nextY, n, m) || memo[nextX][nextY] != INF) {
                        continue;
                    }
                    
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
        
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (map[i][j] != -1) result++;
            }
        }
        
        return result;
    }
    
    boolean validate(int x, int y, int n, int m) {
        return !(x < 0 || y < 0 || x >= n || y >= m); 
    }
}
