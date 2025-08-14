import java.util.*;

class Solution {
    int[] dx = {0, -1, 1, 0};
    int[] dy = {1, 0, 0, -1};
    
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        int[][] map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        
        for (String request : requests) {
            int target = request.charAt(0) - 'A';
            
            if (request.length() == 2) {
                // 크레인: 모든 타겟 제거
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (map[i][j] == target) map[i][j] = -1;
                    }
                }
            } else {
                // 지게차: 접근 가능 타겟 제거
                boolean[][] visited = new boolean[n][m];
                Queue<int[]> queue = new ArrayDeque<>();
                
                // 경계 빈셀 시작
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        boolean isBorder = (i == 0 || i == n-1 || j == 0 || j == m-1);
                        if (isBorder && map[i][j] == -1) {
                            queue.add(new int[]{i, j});
                            visited[i][j] = true;
                        }
                    }
                }
                
                // BFS: 연결된 빈셀 마크
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int x = curr[0], y = curr[1];
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == -1) {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
                
                // 제거 대상 타겟 찾기
                List<int[]> toRemove = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (map[i][j] == target) {
                            boolean accessible = false;
                            for (int d = 0; d < 4; d++) {
                                int nx = i + dx[d];
                                int ny = j + dy[d];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                    accessible = true;
                                    break;
                                } else if (visited[nx][ny]) {
                                    accessible = true;
                                    break;
                                }
                            }
                            if (accessible) {
                                toRemove.add(new int[]{i, j});
                            }
                        }
                    }
                }
                
                // 제거
                for (int[] pos : toRemove) {
                    map[pos[0]][pos[1]] = -1;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != -1) answer++;
            }
        }
        
        return answer;
    }
}