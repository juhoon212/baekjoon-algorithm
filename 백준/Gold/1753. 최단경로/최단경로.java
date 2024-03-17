

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int end; // 가리키는 노드
    int weight; // 가중치

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    static boolean[] visited;
    static int[] distance;
    static ArrayList<Node>[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        A = new ArrayList[V + 1];
        distance = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V ; i++) {
            A[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A[u].add(new Node(v, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        distance[K] = 0;
        queue.add(new Node(K, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (!visited[now.end]) {
                visited[now.end] = true;
            }
            // 현재 정점에서 이어질 다음 정점
            for (int i = 0; i < A[now.end].size(); i++) {
                Node next = A[now.end].get(i);
                // 다음 정점이 방문하지 않았고
                // 현재 가중치 + 해당 정점으로 향하는 가중치 값 < 해당 정점으로의 최단 경로 값이라면
                if (!visited[next.end] && now.weight + next.weight < distance[next.end]) {
                    distance[next.end] = now.weight + next.weight;
                    queue.add(new Node(next.end, distance[next.end]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }





    }
}


