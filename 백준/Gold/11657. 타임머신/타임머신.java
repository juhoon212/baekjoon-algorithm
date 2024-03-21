

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edges {
    int start;
    int end;
    int weight;

    public Edges(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    static ArrayList<Edges> graph;
    static long[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        distance = new long[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.add(new Edges(start, end, weight));
        }

        boolean result = BellmanFord(N, M, 1);

        if (result) {
            System.out.println("-1");
        } else {
            for (int i = 2; i < N + 1; i++) {
                if (distance[i] == Long.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
    }

    private static boolean BellmanFord(int n, int m, int start) {

        for (int i = 1; i <= n; i++) {
            distance[i] = Long.MAX_VALUE;
        }

        distance[start] = 0;

        // 벨만 포드

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                Edges edge = graph.get(j);

                if (distance[edge.start] != Long.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.weight
                ) {
                    distance[edge.end] = distance[edge.start] + edge.weight;
                }
            }
        }

        for (int i = 0; i < m; i++) {

            Edges edge = graph.get(i);

            if (distance[edge.start] != Long.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.weight
            ) {
                return true;
            }
        }

        return false;
    }
}
