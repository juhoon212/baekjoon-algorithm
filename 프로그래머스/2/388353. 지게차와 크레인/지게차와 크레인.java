import java.util.*;

class Solution {
    int[] dx = new int[]{0, -1, 1, 0};
    int[] dy = new int[]{1, 0, 0, -1};
    int answer;
    int INF = 1001;
    public int solution(String[] storage, String[] requests) {
        // 먼저 2차원 배열 생성
        int n = storage.length;
        int m = storage[0].length();
        int[][] map = new int[n][m];
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                map[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        
        for (String request : requests) {
            // 크레인
            int target = request.charAt(0) - 'A';
            
            if (request.length() == 2) {
                for (int i=0; i<n; ++i) {
                    for (int j=0; j<m; ++j) {
                        if (map[i][j] == target) map[i][j] = -1;
                    }
                }                
            }
            
            // 지게차
            int[][] memo = new int[n][m];

            // memo 배열에 int 값 삽입 -> 삭제됬는지 안됬는지 확인
            for (int i=0; i<n; ++i) {
                Arrays.fill(memo[i], INF);
            }
            
            List<int[]> list = new ArrayList<>();
            Queue<int[]> q = new ArrayDeque<>();
            
            for (int i=0; i<n; ++i) {
                for (int j=0; j<m; ++j) {
                    // 출발점 구하기
                    if (i != 0 && j !=0 && i != n-1 && j != m-1) continue;
                    if (map[i][j] != -1) {
                        memo[i][j] = 1;
                        if (map[i][j] == target) list.add(new int[]{i, j});
                        continue;
                    }
                    
                    memo[i][j] = 0;
                    q.add(new int[]{i,j});
                    
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        
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
                            if (map[nextX][nextY] == target) {
                                list.add(new int[]{nextX, nextY});
                            }
                        }
                    }
                }
            }
            
            for (int[] candidate : list) {
                map[candidate[0]][candidate[1]] = -1;
            }
        }
        
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (map[i][j] != -1) answer++;
            }
        }
        
        return answer;
    }
    
    boolean validate(int n, int m, int nextX, int nextY) {
        if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) return false;
        return true;
    }
}