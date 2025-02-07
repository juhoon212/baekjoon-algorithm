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
        visited[0][0] = true;
        
        int result = bfs(visited, grid);

        return result;
    }
    
    public int bfs(boolean[][] visited, int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));

        int dx[] = new int[]{0, 1, -1, 0, -1, 1, 1, -1};
        int dy[] = new int[]{1, 0, 0, -1, 1, -1, 1, -1};
        
        if (grid[0][0] == 1) {
            return defaultCount;
        }
        
        while (!q.isEmpty()) {
            Node poll = q.poll();

            int nowX = poll.getX();
            int nowY = poll.getY();
            int currentCount = poll.getCount();
            
            if (nowX == grid.length-1 && nowY == grid[0].length-1 && grid[nowX][nowY] == 0) {
                defaultCount = currentCount;
                return currentCount;
            }
            
            for (int i=0; i<8; ++i) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                if (isAvailable(nextX, nextY, grid) && isAvailable(visited, nextX, nextY) && grid[nextX][nextY] == 0) {
                    q.offer(new Node(nextX, nextY, currentCount + 1));
                    visited[nextX][nextY] = true;
                }
            }
        }

        return defaultCount;
    }
    
    private boolean isAvailable(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        return true;
    }
    
    private boolean isAvailable(boolean visited[][], int x, int y) {
        if (!visited[x][y]) {
            return true;
        }
        
        return false;
    }
}