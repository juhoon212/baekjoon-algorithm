import java.util.*;

class Solution {
    int[] dx = new int[]{0, 1, -1, 0};
    int[] dy = new int[]{1, 0, 0, -1};
    int answer;
    public int solution(String[] storage, String[] requests) {
        // 2차원 배열 생성
        int n = storage.length;
        int m = storage[0].length();
        final int INF = 100001;
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
            // INF는 한번도 탐색하지 않은 곳
            for (int i=0; i<n; ++i) {
                Arrays.fill(memo[i], INF);
            }
            
            List<int[]> list = new ArrayList<>();
            Queue<int[]> q = new ArrayDeque<>();
            
            for (int i=0; i<n; ++i) {
                for (int j=0; j<m; ++j) {
                    // 출발점 찾기
                    if (i != 0 && j != 0 && i < n-1 && j < m-1) continue;
                    // 삭제 되지 않은 노드라면
                    if (map[i][j] != -1) {
                        memo[i][j] = 1; // 외부
                        if (map[i][j] == target) list.add(new int[]{i, j});
                        continue;
                    }
                    // 나머지는 내부
                    memo[i][j] = 1;
                    q.add(new int[]{i,j});

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for (int k=0; k<4; ++k) {
                            int nowX = now[0] + dx[k];
                            int nowY = now[1] + dy[k];

                            if (!validate(n, m, nowX, nowY) || memo[nowX][nowY] != INF) continue;
                            if (map[nowX][nowY] == -1) {
                                memo[nowX][nowY] = 0;
                                q.add(new int[]{nowX, nowY});
                                continue;
                            }

                            memo[nowX][nowY] = 1;
                            if (map[nowX][nowY] == target) list.add(new int[]{nowX, nowY});
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
    
    boolean validate(int n, int m, int x, int y) {
        if (x < 0 || y < 0 || x > n-1 || y > m-1) return false;
        return true;
    }
}