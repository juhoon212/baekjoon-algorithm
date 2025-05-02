class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        // BFS
        return bfs(maze, entrance);
    }

    int bfs(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{entrance[0], entrance[1], 0});
        int col = maze.length;
        int row = maze[0].length;
        boolean[][] visited = new boolean[col][row];
        visited[entrance[0]][entrance[1]] = true;

        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,-1,0,1};
        int result = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            int[] now = q.poll();

            for (int i=0; i<4; ++i) {
                int nowX = now[0] + dx[i];
                int nowY = now[1] + dy[i];
                int dist = now[2];

                if (nowX >= 0 && nowY >= 0 && nowX < col && nowY < row && maze[nowX][nowY] == '.' && !visited[nowX][nowY]) {
                    if (nowX == 0 || nowY == 0 || nowX == col - 1 || nowY == row - 1) {
                        return dist+1;
                    }
                    
                    visited[nowX][nowY] = true;
                    q.add(new int[]{nowX, nowY, dist+1});
                }
            }
        }

        return -1;
    }
}

// class Solution {
//     public int nearestExit(char[][] maze, int[] entrance) {
//         int m = maze.length, n = maze[0].length;
//         int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[]{entrance[0], entrance[1], 0});

//         boolean[][] visited = new boolean[m][n];
//         visited[entrance[0]][entrance[1]] = true;

//         while (!q.isEmpty()) {
//             int[] currPos = q.poll();
//             int currRow = currPos[0], currCol = currPos[1], currSteps = currPos[2];

//             for (int[] d : direction) {
//                 int nextRow = currRow + d[0];
//                 int nextCol = currCol + d[1];

//                 if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n && 
// 				    maze[nextRow][nextCol] == '.' && !visited[nextRow][nextCol] ) {

//                     if (nextRow == 0 || nextCol == 0 || nextRow == m - 1 || nextCol == n - 1) {
//                         return currSteps + 1;
//                     }

//                     visited[nextRow][nextCol] = true;
//                     q.offer(new int[]{nextRow, nextCol, currSteps + 1});
//                 }
//             }
//         }

//         return -1;
//     }
// }

// // TC: O(m * n)
// // SC: O(m * n) + O(m * n) => O(m * n)