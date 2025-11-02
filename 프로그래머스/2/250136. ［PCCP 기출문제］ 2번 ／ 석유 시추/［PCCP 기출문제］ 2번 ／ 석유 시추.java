import java.util.*;

class Solution {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, -1, 0, 1};
    int answer = 0;
    public int solution(int[][] land) {
        // 수직으로 단 하나만 뚫을 수 있다. -> 열 별로 뚫을 수 있다.
        // 덩어리를 나눠서 기록한다.
        // land[i][j] - 0이면 빈땅, 1이면 석유가 있는 땅
        // bfs를 돌면서 1이면 거기서 부터 덩어리의 사이즈를 기록한다.
        // 기록할때 temp배열에 id + 사이즈를 기록한다.
        
        int n = land.length;
        int m = land[0].length;
        
        int[][] temp = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        
        Map<Integer, Integer> map = new HashMap<>();
        int idx=1;
        
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                // 0이거나 방문했다면 기록하지 않는다.
                if (land[i][j] == 0 || visited[i][j]) continue; 
                
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;
                
                List<int[]> path = new LinkedList<>();
                int sum = 1;
                while (!q.isEmpty()) {
                    int[] now = q.poll();
                    int nx = now[0], ny = now[1];
                    
                    // 덩어리가 뻗어있는 경로 기록
                    path.add(new int[]{nx, ny});
                    
                    for (int k=0; k<4; ++k) {
                        int nextX = nx + dx[k];
                        int nextY = ny + dy[k];
                        
                        if (check(nextX, nextY, n, m)) continue;
                        if (visited[nextX][nextY]) continue;
                        if (land[nextX][nextY] != 0) {
                            q.add(new int[]{nextX, nextY});
                            visited[nextX][nextY] = true;
                            sum++;
                        }
                    }
                }
                
                for (int[] p : path) {
                    temp[p[0]][p[1]] = idx;
                }
                map.put(idx, sum);
                idx++;
            }
        }
        
        
        for (int i=0; i<m; ++i) {
            // 중복 여부 판단 set
            Set<Integer> set = new HashSet<>();
            // 열 별로 최댓값 구하기
            int total = 0;
            
            for (int j=0; j<n; ++j) {
                int curIdx = temp[j][i];
                
                if (curIdx != 0 && set.add(curIdx)) {
                    total += map.get(curIdx);
                }
            }
            answer = Math.max(answer, total);
        }
        return answer;
    }
    
    boolean check(int x, int y, int n, int m) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}
