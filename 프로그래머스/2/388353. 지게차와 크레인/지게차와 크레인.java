import java.util.*;

class Solution {
    int[] dx = new int[]{0, -1, 0, 1};
    int[] dy = new int[]{1, 0, -1, 0};
    int answer;
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        // 1.map 생성 후 초기화
        int[][] map = new int[n][m];
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                map[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        for (String request : requests) {
            int target = request.charAt(0) - 'A';
            // 2.크레인 -> request의 길이가 2
            if (request.length() == 2) {
                for (int i=0; i<n; ++i) {
                    for (int j=0; j<m; ++j) {
                        // -1 은 삭제노드
                        if (map[i][j] == target) map[i][j] = -1;
                    }
                }
                
                continue;
            }
            // 3.지게차 -> 길이가 1 visited 배열로 방문한 노드인지 판별
            boolean[][] visited = new boolean[n][m];
            Queue<int[]> q = new ArrayDeque<>();
            // 3-1. bfs 시작점 구하기 - 테두리에서만 시작해야함
            for (int i=0; i<n; ++i) {
                for (int j=0; j<m; ++j) {
                    if (i == 0 || j == 0 || i == n-1 || j == m-1) {
                        if (map[i][j] == -1) {
                            q.add(new int[]{i, j});
                            visited[i][j] = true;
                            continue;
                        } 
                        if (map[i][j] == target) {
                            map[i][j] = -1;
                            visited[i][j] = true;
                        }
                    }
                }
            }
            
//             int[][] deleted = new int[n][m];
            
//             for (int i=0; i<n; ++i) {
//                 // 0은 삭제 안된 노드, 1은 삭제해야하는 노드
//                 Arrays.fill(deleted[i], 0);
//             }
            
            // 테두리 타깃 미리 표시
            // for (int i=0; i<n; ++i) {
            //     if (map[i][0] == target) deleted[i][0] = 1;
            //     if (map[i][m-1] == target) deleted[i][m-1] = 1;
            // }
            // for (int j=0; j<m; ++j) {
            //     if (map[0][j] == target) deleted[0][j] = 1;
            //     if (map[n-1][j] == target) deleted[n-1][j] = 1;
            // }
            
            // 3-2. bfs
            while (!q.isEmpty()) {
                int[] now = q.poll();
                
                // 3-3. 지게차가 갈 수 있는 경로로 탐색하면서
                for (int i=0; i<4; ++i) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if (check(n, m, nx, ny)) continue;
                    if (visited[nx][ny]) continue;
                    
                    if (map[nx][ny] == -1) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        continue;
                    } 
                    if (map[nx][ny] == target) {
                        map[nx][ny] = -1;
                        visited[nx][ny] = true;
                    }
                }
            }
            
            // 삭제 가능한 노드 삭제
            // only 지게차
            // for (int i=0; i<n; ++i) {
            //     for (int j=0; j<m; ++j) {
            //         if (deleted[i][j] == 1) map[i][j] = -1;
            //     }
            // }
        }
        // map에서 삭제 된 노드 제외하고 남아있는 노드 계산
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (map[i][j] != -1) answer++;
            }
        }
        
        return answer;
    }
    
    boolean check(int n, int m, int x, int y) {
        return x < 0 || y < 0 || x > n-1 || y > m-1;
    }
}