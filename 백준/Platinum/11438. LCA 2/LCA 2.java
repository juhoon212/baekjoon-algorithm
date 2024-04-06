import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.lang.Math.*;

public class Main {

    static int N, M;
    static List<Integer>[] tree;
    static int[] depth;
    static int kmax;
    static int[][] parent = new int[21][100001];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            final int start = Integer.parseInt(st.nextToken());
            final int end = Integer.parseInt(st.nextToken());

            tree[start].add(end);
            tree[end].add(start);
        }

        // N이 노드의 개수
        int temp = 1;
        kmax = 0;

        while (temp <= N) {
            temp <<= 1; // x2
            kmax++;
        }

        bfs(1);
        // 부모 2차원 배열 채우기
        for (int k = 1; k <= kmax; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());

            int result = lca(a, b);
            System.out.println(result);
        }

        br.close();
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        int level = 1;
        int nowSize = 1;
        int count = 0;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer next : tree[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[0][next] = now;
                    depth[next] = level;
                }
            }

            count++;
            if (count == nowSize) {
                count = 0;
                nowSize = queue.size();
                level++;
            }
        }

    }

    private static int lca(int a, int b) {

        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 깊이 맞추기
        for (int k = kmax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                b = parent[k][b];
            }
        }

        // 동시에 올라가면서 조상찾기
        for (int k = kmax; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int lca = a;
        if (a != b) {
            lca = parent[0][lca];
        }

        return lca;
    }
}
