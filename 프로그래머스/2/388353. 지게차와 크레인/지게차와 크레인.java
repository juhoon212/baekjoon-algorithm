import java.util.*;

class Solution {
    int[] dx = new int[]{0, -1, 1, 0};
    int[] dy = new int[]{1, 0, 0, -1};
    final int INF = 10001;
    int answer;
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        // 1. 먼저 2차원 배열을 만들고 각 알파벳 세팅
        int[][] wareHouse = new int[n][m];
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                wareHouse[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        // requests를 돌면서  
        for (String request : requests) {
            int target = request.charAt(0) - 'A';
            // requests의 알파벳 길이가 2이면 크레인 이용
            if (request.length() == 2) {
                for (int i=0; i<n; ++i) {
                    for (int j=0; j<m; ++j) {
                        if (wareHouse[i][j] == target) wareHouse[i][j] = -1;
                    }
                }
            }
            
            // 1이면 지게차 이용
            // 지게차는 가장 자리에 있는 것만 삭제 가능
            int[][] memo = new int[n][m];
            for (int i=0; i<n; ++i) {
                Arrays.fill(memo[i], INF);
            }
            List<int[]> list = new ArrayList<>(); // 제거대상
            Queue<int[]> q = new ArrayDeque<>();
            
            for (int i=0; i<n; ++i) {
                for (int j=0; j<m; ++j) {
                    if (i != 0 && j != 0 && i != n-1 && j != m-1) continue;
                    //if (memo[i][j] != INF) continue;
                    if (wareHouse[i][j] != -1) {
                        memo[i][j] = 1;
                        
                        if (wareHouse[i][j] == target) list.add(new int[]{i, j});
                        continue;
                    }
                    
                    memo[i][j] = 0;
                    q.add(new int[]{i, j});
                    
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        
                        for (int k=0; k<4; ++k) {
                            int nowX = now[0] + dx[k];
                            int nowY = now[1] + dy[k];
                            if (!validation(nowX, nowY, n, m) || memo[nowX][nowY] != INF) continue;
                            if (wareHouse[nowX][nowY] == -1) {
                                memo[nowX][nowY] = 0;
                                q.add(new int[]{nowX, nowY});
                                continue;
                            }
                            memo[nowX][nowY] = 1;
                            if (wareHouse[nowX][nowY] == target) {
                                list.add(new int[]{nowX, nowY});
                            }
                        }
                    }
                }
            }
            
            for (int[] next : list) {
                wareHouse[next[0]][next[1]] = -1;
            }
        }
            
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (wareHouse[i][j] != -1) answer++;
            }
        }
        
        return answer;
    }
    
    boolean validation(int nowX, int nowY, int n, int m) {
        if (nowX < 0 || nowX >= n || nowY < 0 || nowY >= m) return false;
        return true;
    }
}