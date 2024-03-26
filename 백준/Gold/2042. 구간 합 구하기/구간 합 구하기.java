
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());


        int treeHeight = 0;
        long length = N;

        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int NodeStartIndex = treeSize / 2;

        tree = new long[(int) (treeSize + 1)];

        for (int i = NodeStartIndex; i < NodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1); // 트리세팅

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken()); // 질의 유형
            long s = Long.parseLong(st.nextToken()); // 시작 인덱스
            long e = Long.parseLong(st.nextToken()); // 종료 인덱스 or 변경 값

            if (a == 1) { // 데이터 변경
                changeVal( (s + NodeStartIndex - 1), e); // 해당 인덱스 + 2^k-1
            }else if (a == 2) { // 구간합 구하기
                s = s + NodeStartIndex - 1;
                e = e + NodeStartIndex - 1;
                long sum = getSum(s, e);

                System.out.println(sum);
            }
        }

        br.close();
    }

    private static void setTree(int i) {

        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }

    private static void changeVal(long index, long val) {
        long diff = val - tree[(int) index]; // 더
        while (index > 0) {
            tree[(int) index] += diff;
            index /= 2;
        }
    }

    private static long getSum(long start, long end) {
        long partSum = 0;

        while (start <= end) {
            if (start % 2 == 1) {
                partSum = (partSum + tree[(int) start]);
            }

            if (end % 2 == 0) {
                partSum = (partSum + tree[(int) end]);
            }

            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }

        return partSum;
    }
}
