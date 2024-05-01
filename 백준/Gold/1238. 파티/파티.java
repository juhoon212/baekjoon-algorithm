
import java.io.*;
import java.util.*;

class Node1238 implements Comparable<Node1238>{
    int end;
    int weight;

    public Node1238(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node1238 o) {
        return this.weight - o.weight;
    }
}

public class Main {

    static ArrayList<ArrayList<Node1238>> graph;
    static ArrayList<ArrayList<Node1238>> revGraph;

    static int N, M, X;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        revGraph = new ArrayList<>();


        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }



        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node1238(end, cost));
            revGraph.get(end).add(new Node1238(start, cost));
        }

         int[] distOrigin = dijkstra(graph);
         int[] distRev = dijkstra(revGraph);

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, distOrigin[i] + distRev[i]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    private static int[] dijkstra(ArrayList<ArrayList<Node1238>> arr) {

        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;

        PriorityQueue<Node1238> queue = new PriorityQueue<>();
        queue.offer(new Node1238(X, 0));


        while (!queue.isEmpty()) {
            final Node1238 poll = queue.poll();
            int cur = poll.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node1238 node : arr.get(cur)) {
                    if (!visited[node.end] && distance[node.end] > distance[cur] + node.weight) {
                        distance[node.end] = distance[cur] + node.weight;
                        queue.add(new Node1238(node.end, distance[node.end]));
                    }
                }
            }
        }
        return distance;
    }
}
