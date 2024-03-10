
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] presentNode;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        presentNode = new int[n + 1];

        // 대표노드 초기화
        for (int i = 1; i <= n ; i++) {
            presentNode[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int unionOrFind = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (unionOrFind == 0) {
                union(a, b);
            } else {
                boolean result = checkSame(a, b);

                if (result) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) {
            return true;
        }

        return false;
    }

    private static void union(int a, int b) {
        
        a = find(a);
        b = find(b);

        if (presentNode[a] != presentNode[b]) {
            presentNode[a] = b;
        }
    }

    private static int find(int num) {
        if (presentNode[num] == num) {
            return num;
        } else {
            return presentNode[num] = find(presentNode[num]);
        }
    }
}
