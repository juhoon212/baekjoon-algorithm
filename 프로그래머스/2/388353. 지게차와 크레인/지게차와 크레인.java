import java.util.*;

class Solution {
    int[] dx = new int[]{0, -1, 1, 0};
    int[] dy = new int[]{1, 0, 0, -1};
    int answer;
    final int INF = 1001;
    public int solution(String[] storage, String[] requests) {
        // 2차원 배열 생성
        int n = storage.length;
        int m = storage[0].length();
        
        int[][] map = new int[n][m];
        
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                map[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        
        // target 마다 지게차, 크레인 로직 실행
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
            for (int i=0; i<n; ++i) {
                Arrays.fill(memo[i], INF);
            }
            
            List<int[]> list = new ArrayList<>();
            Queue<int[]> q = new ArrayDeque<>();
            
            for (int i=0; i<n; ++i) {
                for (int j=0; j<m; ++j) {
                    // 출발점 찾기
                    if (i != 0 && j != 0 && i < n-1 && j < m-1) continue;
                    if (map[i][j] != -1) {
                        memo[i][j] = 1;
                        if (map[i][j] == target) list.add(new int[]{i, j});
                        continue;
                    }
                    
                    // 내부 
                    memo[i][j] = 0;
                    q.add(new int[]{i, j});
                    
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        
                        for (int k=0; k<4; ++k) {
                            int nextX = now[0] + dx[k];
                            int nextY = now[1] + dy[k];
                            
                            if (!validate(nextX, nextY, n, m) || memo[nextX][nextY] != INF) continue;
                            if (map[nextX][nextY] == -1) {
                                memo[nextX][nextY] = 0;
                                q.add(new int[]{nextX, nextY});
                                continue;
                            }
                            
                            memo[nextX][nextY] = 1;
                            if (map[nextX][nextY] == target) list.add(new int[]{nextX, nextY});
                        }
                    }
                }
            }
            
            for (int[] now: list) {
                map[now[0]][now[1]] = -1;
            }
        }
        
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (map[i][j] != -1) answer++;
            }
        }
        
        return answer;
    }
    
    boolean validate(int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x > n-1 || y > m-1) return false;
        return true;
    }
}