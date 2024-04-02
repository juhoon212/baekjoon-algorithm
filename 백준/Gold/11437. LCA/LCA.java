
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;
    static int[] depth;
    static boolean[] visited;
    static Node[] graph;
    static StringTokenizer st;

    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            super();
            this.vertex = vertex;
            this.link = link;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new Node[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start] = new Node(end, graph[start]);
            graph[end] = new Node(start, graph[end]);
        }
        dfs(1, 0);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(lca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    static void dfs(int v, int d) {
        visited[v] = true;
        depth[v] = d;

        for (Node temp = graph[v]; temp != null; temp = temp.link) {
            if (!visited[temp.vertex]) {
                parent[temp.vertex] = v;
                dfs(temp.vertex, d + 1);
            }
        }
    }

    static int lca(int a, int b) {
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b])
                a = parent[a];
            else
                b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}