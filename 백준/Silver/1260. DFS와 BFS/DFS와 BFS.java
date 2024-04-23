
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int N, M, V;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            final int start = Integer.parseInt(st.nextToken());
            final int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);

    }

    private static void dfs(int start) {

        visited[start] = true;
        System.out.print(start + " ");

        for (Integer now : graph[start]) {
            if (!visited[now]) {
                dfs(now);
            }
        }
    }

    private static void bfs(int node) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            final Integer poll = queue.poll();
            System.out.print(poll + " ");

            for (int now: graph[poll]) {
                if (!visited[now]) {
                    visited[now] = true;
                    queue.add(now);
                }
            }
        }
    }
}
