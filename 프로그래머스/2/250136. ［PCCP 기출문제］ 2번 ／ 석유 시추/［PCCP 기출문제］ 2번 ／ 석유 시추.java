import java.util.*;

class Solution {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, -1, 0, 1};
    int answer;

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        int[][] temp = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Map<Integer, Integer> oilSize = new HashMap<>(); // 덩어리 ID -> 석유량
        int id = 1;

        // 1️⃣ 전체 맵 한 번만 탐색해서 덩어리별로 sum 저장
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (land[i][j] == 0 || visited[i][j]) continue;

                int sum = 0;
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;

                List<int[]> path = new ArrayList<>();

                while (!q.isEmpty()) {
                    int[] now = q.poll();
                    int x = now[0];
                    int y = now[1];
                    path.add(now);
                    sum++;

                    for (int k = 0; k < 4; ++k) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (check(nx, ny, n, m)) continue;
                        if (visited[nx][ny] || land[nx][ny] == 0) continue;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }

                // 덩어리 ID 기록
                for (int[] p : path) {
                    temp[p[0]][p[1]] = id;
                }
                oilSize.put(id, sum);
                id++;
            }
        }

        // 2️⃣ 열 단위로 덩어리 합산
        for (int j = 0; j < m; ++j) {
            Set<Integer> set = new HashSet<>();
            int total = 0;
            for (int i = 0; i < n; ++i) {
                int oilId = temp[i][j];
                if (oilId > 0 && set.add(oilId)) {
                    total += oilSize.get(oilId);
                }
            }
            answer = Math.max(answer, total);
        }

        return answer;
    }

    boolean check(int x, int y, int n, int m) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}
