

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 학생 수
        int N = Integer.parseInt(st.nextToken());
        // 키를 비교한 횟수
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            inDegree[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now + " ");
            for (Integer i : graph[now]) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }


    }
}
