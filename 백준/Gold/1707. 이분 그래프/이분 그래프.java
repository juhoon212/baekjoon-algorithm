
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean visited[];
    static boolean IsEven;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]); // 노드갯수
            int E = Integer.parseInt(s[1]); // 엣지갯수
            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;
            for (int j = 1; j <= V ; j++) {
                A[j] = new ArrayList<>();
            }
            // 엣지 데이터 저장하기
            for (int j = 0; j < E; j++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                // 무방향 그래프이면 방향을 넣어줘야한다.
                A[start].add(end);
                A[end].add(start);
            }

            // 모든 노드에서 DFS 실행
            for (int j = 1; j <= V; j++) {

                if(IsEven) {
                    dfs(j);
                } else {
                    break;
                }
            }

            if(IsEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void dfs(int start) {

        visited[start] = true;
        for (Integer i : A[start]) { // 인접리스트로 받아서 start 에서 연결된 모든 노드를 탐색하게된다.
            if(!visited[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요
                check[i] = (check[start] + 1) % 2;
                dfs(i);
            } else {
                if(check[start] == check[i]) {
                    IsEven = false;
                }
            }
        }
    }
}