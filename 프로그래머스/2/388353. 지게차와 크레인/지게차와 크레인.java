import java.util.*;

class Solution {
    int[] dx = new int[]{0, -1, 1, 0};
    int[] dy = new int[]{1, 0, 0, -1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        final int INF = 100000001;
        int answer = 0;

        int[][] map = new int[n][m];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                map[i][j] = storage[i].charAt(j) - 'A';

        for (String request : requests) {
            int target = request.charAt(0) - 'A';

            // 지게차 요청
            if (request.length() == 2) {
                for (int i = 0; i < n; ++i)
                    for (int j = 0; j < m; ++j)
                        if (map[i][j] == target)
                            map[i][j] = -1;
                continue;
            }

            // 크레인 요청
            int[][] memo = new int[n][m];
            Queue<int[]> q = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) Arrays.fill(memo[i], INF);

            // 1. 가장자리에서 BFS 시작점 수집
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (!(i == 0 || i == n - 1 || j == 0 || j == m - 1)) continue;

                    if (map[i][j] == -1) {
                        memo[i][j] = 0;
                        q.add(new int[]{i, j});
                    } else {
                        memo[i][j] = 1;
                        if (map[i][j] == target) map[i][j] = -1;
                    }
                }
            }

            // 2. BFS 단 한 번 수행
            while (!q.isEmpty()) {
                int[] now = q.poll();
                for (int k = 0; k < 4; ++k) {
                    int nextX = now[0] + dx[k];
                    int nextY = now[1] + dy[k];
                    if (!validate(n, m, nextX, nextY) || memo[nextX][nextY] != INF) continue;

                    if (map[nextX][nextY] == -1) {
                        memo[nextX][nextY] = 0;
                        q.add(new int[]{nextX, nextY});
                    } else {
                        memo[nextX][nextY] = 1;
                        if (map[nextX][nextY] == target) {
                            map[nextX][nextY] = -1;
                        }
                    }
                }
            }
        }

        // 살아남은 박스 개수 세기
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (map[i][j] != -1) answer++;

        return answer;
    }

    boolean validate(int n, int m, int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
