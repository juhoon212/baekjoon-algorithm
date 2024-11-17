import java.util.*;

class Solution {
     // 5x5 맵 크기
    // 현재 위치 (1, 1)
    // 0은 벽이므로 갈 수 없고, 1은 벽이 없는 자리이므로 갈 수 있다.

    // bfs queue

    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};

    int[][] visited;


    public int solution(int[][] maps) {

        visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;
        return bfs(0, 0, maps);


    }

    private int bfs(int x, int y, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int nowX = pos[0], nowY = pos[1];

            // 상대 진영 도착
            if (nowX == maps.length - 1 && nowY == maps[0].length - 1) {
                return visited[nowX][nowY];
            }

            for (int i=0; i<4; ++i) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < maps.length && nextY < maps[0].length && nextX >= 0 && nextY >= 0) {
                    if (maps[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                        visited[nextX][nextY] = visited[nowX][nowY] + 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return -1;
    }
}