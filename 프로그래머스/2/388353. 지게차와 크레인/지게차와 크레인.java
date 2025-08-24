import java.util.*;

class Solution {
    int[] dx = new int[]{0, -1, 1, 0};
    int[] dy = new int[]{1, 0, 0, -1};
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        
        int[][] map = new int[n][m];
        int answer = 0;
        
        // map 초기화
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                map[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        
        for (String request : requests) {
            int target = request.charAt(0) - 'A';
            // crane
            if (request.length() == 2) {
                for (int i=0; i<n; ++i) {
                    for (int j=0; j<m; ++j) {
                        // 바로 삭제 처리
                        if (map[i][j] == target) map[i][j] = -1;
                    }
                }
                
                continue;
            }
            
            // 지게차
            // visited 배열 생성 - 지게차로 탐색 가능한지
            boolean[][] visited = new boolean[n][m];
            Queue<int[]> q = new ArrayDeque<>();
            
            // 시작점 구하기
            for (int i=0; i<n; ++i) {
                for (int j=0; j<m; ++j) {
                    if (i == 0 || j == 0 || i == n-1 || j == m-1) {
                        if (map[i][j] == -1) {
                            q.add(new int[]{i, j});
                            visited[i][j] = true;
                        }
                        
                        // map[i][j] = 삭제대상이라면 삭제 다음번 request에 탐색가능하게
                        if (map[i][j] == target) {
                            map[i][j] = -1;
                            visited[i][j] = true;
                        }
                    }
                }
            }
            
            // bfs
            while (!q.isEmpty()) {
                int[] now = q.poll();
                
                for (int i=0; i<4; ++i) {
                    int nx = dx[i] + now[0];
                    int ny = dy[i] + now[1];
                    
                    if (check(nx, ny, n, m)) continue;
                    if (visited[nx][ny]) continue;
                    
                    if (map[nx][ny] == -1) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        continue;
                    }
                    
                    if (map[nx][ny] == target) {
                        map[nx][ny] = -1;
                        visited[nx][ny]  = true;
                        
                    }
                }
            }
        }
        
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (map[i][j] != -1) answer++;
            }
        }
        
        return answer;
    }
    
    boolean check(int x, int y, int n, int m) {
        return x < 0 || y < 0 || x > n-1 || y > m-1;
    }
}