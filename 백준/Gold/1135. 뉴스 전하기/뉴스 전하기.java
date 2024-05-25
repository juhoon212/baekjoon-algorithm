
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static ArrayList<Integer>[] tree;
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i < n; i++) {
            tree[input[i]].add(i);
        }

        System.out.println(dfs(0));
    }

    private static int dfs(int cur) {

        int cnt = 0, max = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (Integer next: tree[cur]) {
            dp[next] = dfs(next);
            queue.add(new int[]{next, dp[next]});
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            cnt++;
            max = Math.max(max, node[1] + cnt);
        }

        return max;
    }
}


