

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node1504 implements Comparable<Node1504>{
    int end;
    int weight;

    public Node1504(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node1504 o) {
        return this.weight - o.weight;
    }
}

public class Main {

    static ArrayList<ArrayList<Node1504>> graph;
    static int N, E;

    static boolean[] visited;
    static int[] distance;

    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        graph = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(distance, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            final int start = Integer.parseInt(st.nextToken());
            final int end = Integer.parseInt(st.nextToken());
            final int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node1504(end, cost));
            graph.get(end).add(new Node1504(start, cost));
        }
        st = new StringTokenizer(br.readLine());
        final int v1 = Integer.parseInt(st.nextToken());
        final int v2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        // 1 -> v1 -> v2 -> end
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);

        int result2 = 0;
        // 1 -> v2 -> v1 -> end
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        int answer = (result1 >= INF  && result2 >= INF) ? -1 : Math.min(result1, result2);
        System.out.println(answer);

        br.close();
    }

    private static int dijkstra(int start, int end) {

        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);
        distance[start] = 0;

        PriorityQueue<Node1504> queue = new PriorityQueue<>();
        queue.add(new Node1504(start, 0));



        while (!queue.isEmpty()) {
            Node1504 poll = queue.poll();
            int cur = poll.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node1504 node : graph.get(cur)) {
                    if (!visited[node.end] && distance[node.end] > distance[cur] + node.weight) {
                        distance[node.end] = distance[cur] + node.weight;
                        queue.add(new Node1504(node.end, distance[node.end]));
                    }
                }
            }
        }

        return distance[end];
    }
}
