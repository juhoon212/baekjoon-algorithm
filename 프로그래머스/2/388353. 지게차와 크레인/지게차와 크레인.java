import java.util.*;

class Solution {
    int[] dx = new int[]{0, -1, 0, 1};
    int[] dy = new int[]{1, 0, -1, 0};
    int answer;
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        final int INF = 10001;
        
        // 2차원 배열 생성
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
                        // 삭제 처리
                        if (map[i][j] == target) map[i][j] = -1;
                    }
                }
            }
            
            // request마다 memo 배열을 생성
            int[][] memo = new int[n][m];
            
            for (int i=0; i<n; ++i) {
                // 방문 x, 삭제된지도 모르면 INF
                Arrays.fill(memo[i], INF);
            }
            
            // 삭제 예정 리스트
            List<int[]> list = new ArrayList<>();
            Queue<int[]> q = new ArrayDeque<>();
            
            for (int i=0; i<n; ++i) {
                for (int j=0; j<m; ++j) {
                    // 출발점 구하기 - 가장자리가 아니면 pass
                    if (i != 0 && j != 0 && i < n-1 && j < m-1) continue;
                    // 삭제되지 않은 지점이라면
                    if (map[i][j] != -1) {
                        // 방문했다.
                        memo[i][j] = 1;
                        if (map[i][j] == target) list.add(new int[]{i, j});
                        continue;
                    }
                    
                    // 미방문
                    memo[i][j] = 0;
                    q.add(new int[]{i, j});
                    
                    while (!q.isEmpty()) {
                        int now[] = q.poll();
                        
                        for (int k=0; k<4; ++k) {
                            int nextX = now[0] + dx[k];
                            int nextY = now[1] + dy[k];
                            
                            if (!validate(n, m, nextX, nextY) || memo[nextX][nextY] != INF) continue;
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
            
            for (int[] now : list) {
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
    
        boolean validate(int n, int m, int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }
}