class Solution {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, -1, 0, 1};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i=0; i<grid.length; ++i) {
            for (int j=0; j<grid[0].length; ++j) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        return bfs(grid, queue, fresh);
    }

    int bfs(int[][] grid, Queue<int[]> queue, int fresh) {

        int minutes = -1;

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            minutes++;

            for (int i=0; i<qSize; ++i) {
                int[] cur = queue.poll();

                for (int d=0; d<4; ++d) {
                    int nowX = cur[0] + dx[d];
                    int nowY = cur[1] + dy[d];

                    if (nowX >= 0 && nowX < grid.length && nowY >= 0 && nowY < grid[0].length) {
                        if (grid[nowX][nowY] == 1) {
                            grid[nowX][nowY] = 2;
                            fresh--;
                            queue.offer(new int[]{nowX, nowY});
                        }
                    }
                }
            }            
        }

        return fresh == 0 ? minutes : -1;
    }
    
}