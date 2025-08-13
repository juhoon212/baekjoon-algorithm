import java.util.*;

class Solution {
    int[] dx = new int[]{0, -1, 1, 0};
    int[] dy = new int[]{1, 0, 0, -1};
    int answer = 0;
    
    public int solution(String[] storage, String[] requests) {
        // 이차원 배열 탐색 bfs
        int n = storage.length;
        int m = storage[0].length();
        // 1. map 즉 이차원 배열 생성
        int[][] map = new int[n][m];
        // 1-1. map 초기화 storage에 있는 알파벳 - 'A' 로 int로 만듬
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                map[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        
        for (String request : requests) {
            int target = request.charAt(0) - 'A';
            // 2. 크레인 로직 구현 length = 2
            if (request.length() == 2) {
                // 2-1. 크레인은 어떤 노드라도 탐색 가능
                for (int i=0; i<n; ++i) {
                    for (int j=0; j<m; ++j) {
                        if (map[i][j] == target) map[i][j] = -1; // 철거
                    }
                }
                continue; // 다음 request로
            }
            // 3. 지게차 로직 구현 length = 1
            // 3-1. 지게차는 상하좌우 중 외부랑 하나라도 연결이 되어있는 노드여야 탐색 가능
            // 3-2.다음에 갈 수 있는 노드인지 아닌지 판단할때 기록해둘 수 있는 temp 배열이 필요
            // temp = -1 : 아직 탐색 안함, 0 : 외부 연결 x, 1: 외부 연결 o
            
            int[][] memo = new int[n][m];
            
            for (int i=0; i<n; ++i) {
                Arrays.fill(memo[i], -1); // 초기화
            }
            
            // 시작점을 Queue의 첫 값에 입력
            Queue<int[]> q = new ArrayDeque<>();
            for (int i=0; i<n; ++i) {
                for (int j=0; j<m; ++j) {
                    // 시작점은 테두리에서 시작해야함. 안에서 시작하면 두번째 그림처럼 상하좌우 막혀있는 곳을 아니라고 판별할 수 있음
                    if (i != 0 && j != 0 && i < n-1 && j < m-1) continue;
                    if (map[i][j] == -1) { // 이미 삭제된 노드라면
                        memo[i][j] = 1; // 외부와 연결되어 있다고 기록
                        q.add(new int[]{i,j}); // 탐색할 노드 저장
                    } else {
                        memo[i][j] = 0;
                        if (map[i][j] == target) {
                            map[i][j] = -1;
                        }
                    }
                }
            }
            
            while (!q.isEmpty()) {
                int now[] = q.poll();
                
                for (int i=0; i<4; ++i) {
                    int nextX = dx[i] + now[0];
                    int nextY = dy[i] + now[1];
                    
                    // map의 범위초과 혹은 아직 탐색하지 전인 노드가 아니라면
                    if (check(n, m, nextX, nextY) || memo[nextX][nextY] != -1) continue;
                    if (map[nextX][nextY] == -1) {
                        memo[nextX][nextY] = 1;
                        q.add(new int[]{nextX, nextY});
                    } else {
                        if (map[nextX][nextY] == target) map[nextX][nextY] = -1;
                        memo[nextX][nextY] = 0;
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
    
    boolean check(int n, int m, int x, int y) {
        return x < 0 || y < 0 || x > n-1 || y > m-1;
    }
}
