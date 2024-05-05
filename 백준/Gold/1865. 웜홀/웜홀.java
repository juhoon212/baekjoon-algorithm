import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge1865 {
    int start;
    int end;
    int weight;

    public Edge1865(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    static int N, M, W, testcase;
    static int[] distance;
    static ArrayList<Edge1865> road;

    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        testcase = Integer.parseInt(br.readLine());
        int index = testcase;

        while (index-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            road = new ArrayList<>();
            distance = new int[N + 1];

            // 양방향
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                if (i < M) {
                    road.add(new Edge1865(s, e, t));
                    road.add(new Edge1865(e, s, t));
                } else {
                    road.add(new Edge1865(s, e, -t));
                }
            }

            if (bellmanFord()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }



        bw.flush();
        bw.close();
        br.close();

    }

    private static boolean bellmanFord() {

        Arrays.fill(distance, INF);
        distance[1] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < road.size(); j++) {
                Edge1865 edge = road.get(j);

                if (distance[edge.end] > distance[edge.start] + edge.weight) {
                    distance[edge.end] = distance[edge.start] + edge.weight;
                }
            }
        }

        for (int i = 0; i < road.size(); i++) {
            Edge1865 edge = road.get(i);

            if (distance[edge.end] > distance[edge.start] + edge.weight) {
                return true;
            }
        }

        return false;

    }


}
