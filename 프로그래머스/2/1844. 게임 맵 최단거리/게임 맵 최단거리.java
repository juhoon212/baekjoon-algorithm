import java.util.*;

class Solution {
     // 5x5 맵
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, -1, 0, 1};



    public int solution(int[][] maps) {

        int[][] visited = new int[maps.length][maps[0].length];

        visited[0][0] = 1;

        return bfs(0, 0, visited, maps);
    }

    int bfs(int x, int y, int[][] visited, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});



        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int nowX = pos[0], nowY = pos[1];

            // 상대 진영에 도착 시
            if (nowX == maps.length - 1 && nowY == maps[0].length - 1) {
                return visited[nowX][nowY];
            }

            for (int i = 0; i < 4; ++i) {
                int subX = nowX + dx[i], subY = nowY + dy[i];

                    if (subX >= 0
                            && subX < maps.length
                            && subY >= 0 && subY < maps[0].length
                            && maps[subX][subY] == 1
                            && visited[subX][subY] == 0
                    ) {
                        queue.offer(new int[]{subX, subY});
                        visited[subX][subY] = visited[nowX][nowY] + 1;
                    }
            }
        }

        return -1;
    }
}