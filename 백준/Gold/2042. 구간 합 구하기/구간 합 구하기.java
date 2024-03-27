

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  <세그먼트 트리> => 수의 변경이나 합이 빈번히 일어남
 *  1. 트리 초기화
 *  2. 부모 노드값 채우기
 *  3. 질의 값 구하기 => (start + 1 / 2) , (end - 1 / 2)
 *  4. 업데이트
 */


public class Main {

    // -2^63 >= 주어진수 <= 2^63-1
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken()); // 수의 개수
        long M = Long.parseLong(st.nextToken()); // 수의 변경 횟수
        long K = Long.parseLong(st.nextToken()); // 구간 합 횟수

        long treeHeight = 0;
        long temp = N;

        while (temp > 0) {
            temp /= 2;
            treeHeight++;
        }

        long treeSize = (long) Math.pow(2, treeHeight + 1);
        long startNodeIndex = treeSize / 2;

        tree = new long[(int) treeSize];

        for (int i = (int) startNodeIndex; i < startNodeIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                changeVal(b + startNodeIndex - 1, c);
            } else if (a == 2) {
                long result = getSum(b + startNodeIndex - 1, c + startNodeIndex - 1);
                System.out.println(result);
            }
        }

        br.close();

    }

    private static void setTree(long num) {

        while (num > 0) {
            tree[(int) num / 2] += tree[(int)num];
            num--;
        }
    }

    private static void changeVal(long index, long value) {
        long diff = value - tree[(int) index];

        while (index > 0) {
            tree[(int) index] += diff;
            index /= 2;
        }
    }

    private static long getSum(long start, long end) {
        long result = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                result += tree[(int) start];
            }

            if (end % 2 == 0) {
                result += tree[(int) end];
            }

            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }

        return result;
    }
}
