class Solution {
    class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getCount() {
            return this.count;
        }
    }

    int defaultCount = -1;

    public int shortestPathBinaryMatrix(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;


        boolean visited[][] = new boolean[x][y];

        if (grid[0][0] == 1 || grid[x-1][y-1]==1) {
            return defaultCount;
        }

        int result = bfs(grid, visited);

        return result;
    }

    public int bfs(int[][] grid, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        // 대각선으로 이동 가능
        int dx[] = {0, 1, -1, 0, 1, 1, -1, -1};
        int dy[] = {-1, 0, 0, 1, 1, -1, -1, 1};


        while (!q.isEmpty()) {
            Node poll = q.poll();

            int nowX = poll.getX();
            int nowY = poll.getY();
            int curCount = poll.getCount();

            if (nowX == grid.length-1 && nowY == grid[0].length-1 && grid[nowX][nowY] == 0) {
                defaultCount = curCount;
                return defaultCount;
            }

            for (int i=0; i<8; ++i) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (isPossible(nextX, nextY, grid) && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                    q.offer(new Node(nextX, nextY, curCount + 1));
                    visited[nextX][nextY] = true;
                }
            }
        }
        return defaultCount;
    }

    private boolean isPossible(int x, int y, int grid[][]) {
        int limitX = grid.length;
        int limitY = grid[0].length;

        if (x<0 || y<0 || x >= limitX || y >= limitY) {
            return false;
        }
        return true;
    }
}