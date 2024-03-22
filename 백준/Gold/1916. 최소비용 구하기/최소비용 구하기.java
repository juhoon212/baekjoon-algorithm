import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Nodes2 {
    int end;
    int weight;

    public Nodes2(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    static ArrayList<Nodes2>[] graph;
    static boolean[] visited;
    static long[] distance;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        distance = new long[N + 1];

        // distance 배열 초기화
        for (int i = 1; i <= N; i++) {
            distance[i] = Long.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Nodes2(end, cost));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        br.close();
    }

    private static void dijkstra(int start, int end) {

        distance[start] = 0;

        PriorityQueue<Nodes2> queue = new PriorityQueue<>(
                (o1, o2) -> o1.weight - o2.weight
        );

        queue.offer(new Nodes2(start, 0));

        while (!queue.isEmpty()) {
            Nodes2 now = queue.poll();
            if (!visited[now.end]) {
                visited[now.end] = true;
            

            for (int i = 0; i < graph[now.end].size(); i++) {
                Nodes2 next = graph[now.end].get(i);

                if (!visited[next.end]
                        && distance[next.end] > now.weight + next.weight
                ) {
                    distance[next.end] = now.weight + next.weight;
                    queue.offer(new Nodes2(next.end, (int) distance[next.end]));
                }
            }
        }
        }
            System.out.println(distance[end]);
    }
}
