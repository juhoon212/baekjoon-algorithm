class Solution {
     class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
    }

    public int numIslands(char[][] grid) {

        boolean visited[][] = new boolean[grid.length][grid[0].length];

        int count = 0;

        for (int i=0; i<grid.length; ++i) {
            for (int j=0; j<grid[0].length; ++j) {
                // graph 의 현재 좌표가 1이거나 방문하지 않은 노드라면 bfs 돌린다.
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int x, int y, char[][] grid, boolean[][] visited) {

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        
        while (!q.isEmpty()) {
            final Node poll = q.poll();

            int nowX = poll.getX();
            int nowY = poll.getY();
            
            for (int i=0; i<4; ++i) {
                int nextX = dx[i] + nowX;
                int nextY = dy[i] + nowY;
                
                if (isIsland(nextX, nextY, grid) && isIsland(grid[nextX][nextY], visited[nextX][nextY])) {
                    q.offer(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
    
    public boolean isIsland(char island, boolean visited) {
        if (island != '0' && !visited) {
            return true;
        }
        return false;
    }
    
    public boolean isIsland(int x, int y, char grid[][]) {
        int limitX = grid.length;
        int limitY = grid[0].length;
        
        if (x < 0 || y < 0 || x >= limitX || y >= limitY) {
            return false;
        }
        return true;
    }
}