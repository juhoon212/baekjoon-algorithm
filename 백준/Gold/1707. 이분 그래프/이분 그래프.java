
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean isEven;
    static int[] checkArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken()); // 노드 개수
            int E = Integer.parseInt(st.nextToken()); // 간선 개수

            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            checkArr = new int[V + 1];
            isEven = true;

            for (int j = 1; j <= V; j++) {
                A[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                A[start].add(end);
                A[end].add(start);
            }

            for (int j = 1; j <= V ; j++) {
                if (isEven) {
                    dfs(j);
                } else {
                    break;
                }
            }

            if(isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static void dfs(int v) {
        visited[v] = true;

        for (Integer i : A[v]) {
            if(!visited[i]) {
                checkArr[i] = (checkArr[v] + 1) % 2;
                dfs(i);
            } else {
                if (checkArr[v] == checkArr[i]) {
                    isEven = false;
                }
            }
        }
    }
}
