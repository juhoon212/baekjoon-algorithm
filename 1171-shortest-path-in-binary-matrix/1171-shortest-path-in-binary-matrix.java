class Solution {
    static boolean[][] visited;
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    static int rowLength;
    static int colLength;

    public static boolean isValid(int r, int c, int[][] grid) {
        return (r >= 0 && r < rowLength) && (c >= 0 && c < colLength) && (grid[r][c] == 0);
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        rowLength = grid.length;
        colLength = grid[0].length;
        visited = new boolean[rowLength][colLength];

        return bfs(0,0,grid);

    }

    public static int bfs(int r, int c, int[][] grid) {
        int n = grid.length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, 1});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curLow = cur[0];
            int curCol = cur[1];
            int curLength = cur[2];

            if (curLow == n-1 && curCol == n-1) return curLength;

            for (int i = 0; i < 8; i++) {
                int nextLow = curLow + dr[i];
                int nextCol = curCol + dc[i];

                if (isValid(nextLow, nextCol, grid)) {
                    if (!visited[nextLow][nextCol]) {
                        queue.offer(new int[]{nextLow, nextCol, curLength+1});
                        visited[nextLow][nextCol] = true;
                    }
                }
            }
        }
        return -1;
    }
}