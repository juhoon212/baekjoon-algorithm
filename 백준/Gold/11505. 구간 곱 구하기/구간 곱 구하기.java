import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static long tree[];
    static int treeSize;
    static int startIdx;
    static int MOD = 1000000007;



    public static void main(String[] args) throws IOException {
        // 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        // N, M, K를 세팅한다.
        init(st);
        // 트리 높이를 구하고 트리를 세팅한다.
        setTree(br);
        // N + 2번째 줄부터 N+M+K+1 쨰 줄까지 세개의 정수 a,b,c가 주어지는데
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M+K; ++i) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                changeValue((int) (b + startIdx), (int)c);
            } else if (a == 2) {
                sb.append(getValue((int) (startIdx + b), (int) (startIdx + c))).append("\n");
            } else return;
        }

        System.out.println(sb.toString());
        // a == 1 일때는 b번쨰 수를 c로 바꾼다.
        // a == 2 일때는 b부터 c 까지의 곱을 구하여 출력한다.
    }

    private static void init(StringTokenizer st) throws IOException {
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    private static void setTree(BufferedReader br) throws IOException {
        int temp = N;
        int h = 0;

        while (temp != 0) {
            temp /= 2;
            h++;
        }

        treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize + 1];

        startIdx = treeSize / 2 - 1;
        Arrays.fill(tree, 1);

        for (int i=1; i<=N; ++i) {
            tree[i + startIdx] = Long.parseLong(br.readLine());
        }

        // 나머지 세팅
        int index = treeSize - 1;
        while (index != 1) {
            tree[index / 2] = tree[index / 2] * tree[index] % MOD;
            index--;
        }
    }

    private static void changeValue(int target, int value) {
        tree[target] = value;
        int index = target;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2]%MOD * tree[index * 2 + 1]%MOD;
        }
    }

    private static long getValue(int s, int e) {
        long value = 1;

        while (s <= e) {
            if (s % 2 == 1) {
                value = value * tree[s] % MOD;
                s++;
            }

            if (e % 2 == 0) {
                value = value * tree[e] % MOD;
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return value;
    }


}
