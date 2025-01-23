class Solution {
    class Node {
        int x, y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int N, M;
    public int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    
    public int numIslands(char[][] grid) {
        N = grid.length;
        M = grid[0].length;
        
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 섬 발견했는데 아직 방문 안한 섬이면 BFS로 섬 탐색
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    checkIsland(i, j, visited, grid);
                }
            }
        }
        
        return count;
    }
    
    public void checkIsland(int x, int y, boolean[][] visited, char[][] grid) {
        Queue<Node> queue = new LinkedList<Node>();
        
        visited[x][y] = true;
        queue.add(new Node(x, y));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (!isIn(nx, ny) || visited[nx][ny] || grid[nx][ny] == '0')
                    continue;
                
                visited[nx][ny] = true;
                queue.add(new Node(nx, ny));
            }
        } 
        
        return;  
    }
    
    public boolean isIn(int x, int y) {
        if (0 <= x && x < N && 0 <= y && y < M)
            return true;
        return false;
    }
}