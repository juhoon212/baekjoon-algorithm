
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean visited[];

    static boolean result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            final int start = Integer.parseInt(st.nextToken());
            final int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
            A[end].add(start);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (result) {
                break;
            }
        }

        if (result) System.out.println(1);
        else System.out.println(0);

    }

    private static void dfs(int cur, int depth) {

        if (depth == 5 || result) {
            result = true;
            return;
        }

        visited[cur] = true;

        for (Integer next : A[cur]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }

        visited[cur] = false;
    }
}
