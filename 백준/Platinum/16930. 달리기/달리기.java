
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    static boolean[][] visited;
    static String[][] graph;
    static int[][] graph2;


    static int N, M, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new String[N + 1][M + 1];
        graph2 = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = line.substring(j - 1, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        final int sx = Integer.parseInt(st.nextToken());
        final int sy = Integer.parseInt(st.nextToken());
        final int ex = Integer.parseInt(st.nextToken());
        final int ey = Integer.parseInt(st.nextToken());

        bfs(sx, sy, ex, ey);
        if (graph2[ex][ey] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(graph2[ex][ey]);
        }

        br.close();
    }

    private static void bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curRow = poll[0];
            int curCol = poll[1];
            visited[curRow][curCol] = true;

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= K; j++) {
                    final int newRow = curRow + dx[i] * j;
                    final int newCol = curCol + dy[i] * j;

                    if (newRow >= 1 && newRow <= N && newCol <= M && newCol >= 1 && graph[newRow][newCol].equals(".")) {
                        if (!visited[newRow][newCol]) {
                            visited[newRow][newCol] = true;
                            graph2[newRow][newCol] = graph2[curRow][curCol] + 1;

                            if (newRow == ex && newCol == ey) {
                                return;
                            }
                            queue.add(new int[]{newRow, newCol});
                        } else if (graph2[newRow][newCol] <= graph2[curRow][curCol]) break;
                    } else break;
                }
            }
        }
    }



}
