
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static char[][] graph;
    static int[][] distance;
    static int N, M, K;

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][M + 1];
        graph = new char[N + 1][M + 1];
        distance = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            for (int j = 1; j <= M; j++) {
                graph[i][j] = line.charAt(j - 1);
            }
        }

        st = new StringTokenizer(br.readLine());
        final int startRow = Integer.parseInt(st.nextToken());
        final int startCol = Integer.parseInt(st.nextToken());
        final int endRow = Integer.parseInt(st.nextToken());
        final int endCol = Integer.parseInt(st.nextToken());

        bfs(startRow, startCol, endRow, endCol);
        if (distance[endRow][endCol] == 0) {
            System.out.println("-1");
        }else {
            System.out.println(distance[endRow][endCol]);
        }
    }

    private static void bfs(int startRow, int startCol, int endRow, int endCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curRow = poll[0];
            int curCol = poll[1];
//            visited[curRow][curCol] = true;

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= K; j++) {
                    int newRow = curRow + dx[i] * j;
                    int newCol = curCol + dy[i] * j;

                    if (newRow >= 0 && newRow <= N && newCol > 0 && newCol <= M && graph[newRow][newCol] == '.') {
                        if (!visited[newRow][newCol]) {
                            visited[newRow][newCol] = true;
                            distance[newRow][newCol] = distance[curRow][curCol] + 1;

                            if (newRow == endRow && newCol == endCol) return;

                            queue.add(new int[]{newRow, newCol});
                        }else if (distance[newRow][newCol] <= distance[curRow][curCol]) break;
                    } else break;
                }
            }
        }
    }
}
