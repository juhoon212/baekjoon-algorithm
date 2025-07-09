import java.util.*;

class Solution {
    int[] dx = new int[]{0, -1, 1, 0};
    int[] dy = new int[]{1, 0, 0, -1};
    int answer;
    public int solution(String[] storage, String[] requests) {
        // 먼저 2차원 배열 구성
        int n = storage.length;
        int m = storage[0].length();
        
        // 맴에다가 세팅 
        int[][] map = new int[n][m];
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                map[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        
        
        for (String request : requests) {
            int target = request.charAt(0) - 'A';
            // request의 길이가 2이면 크레인
            if (request.length() == 2) {
                for (int i=0; i<n; ++i) {
                    for (int j=0; j<m; ++j) {
                        if (map[i][j] == target) map[i][j] = -1;
                        continue;
                    }
                }
            }
            
            // 지게차
            // 1: 외부 0: 내부 INF: 아직 탐색안함
            int[][] memo = new int[n][m];
            final int INF = 1000000001;
            for (int i=0; i<n; ++i) {
                Arrays.fill(memo[i], INF);
            }
            
            List<int[]> list = new ArrayList<>();
            Queue<int[]> q = new ArrayDeque<>();
            
            for (int i=0; i<n; ++i) {
                for (int j=0; j<m; ++j) {
                    // 출발점 구하기
                    // 출발점은 가장자리여야 한다.
                    // 이유는 내부에서 시작하면 사방이 다 막혀있는 곳을 없앨 수 있기 때문
                    if (i != 0 && j != 0 && i < n-1 && j < m-1) continue;
                    if (map[i][j] != -1) {
                        memo[i][j] = 1; // 외부
                        if (map[i][j] == target) list.add(new int[]{i, j});
                        continue;
                    }
                    
                    memo[i][j] = 1;
                    q.add(new int[]{i, j}); // 출발점
                    
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
                            if (map[nextX][nextY] == target) list.add(new int[]{nextX, nextY});
                            
                            
                        }
                    }
                }
            }
            
            for (int[] d : list) {
                map[d[0]][d[1]] = -1;
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
        if (x < 0 || x > n-1 || y < 0 || y > m-1) return false;
        return true;
    }
}