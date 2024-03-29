

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        // 1. 트리 초기화
        long treeHeight = 0;

        long temp = N;
        while (temp > 0) {
            temp /= 2;
            treeHeight++;
        }

        long treeSize = (long) Math.pow(2, treeHeight + 1);

        tree = new long[(int)treeSize];

        long startNodeIndex = treeSize / 2;

        for (int i = (int)startNodeIndex; i < startNodeIndex + N; i++) {
            tree[i] =  Long.parseLong(br.readLine());
        }
        // 2. 부모 노드 초기화 및 설정
        long index = treeSize - 1;
        while (index > 0) {
            tree[(int)index / 2] += tree[(int)index];
            index--;
        }
        // 3. 질의 값 구하기

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

             long a = Long.parseLong(st.nextToken());
             long b = Long.parseLong(st.nextToken());
             long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // 트리의 인덱스로 변환해야함
                // 해당 index + 2 * treeHeight - 1
                update(b + startNodeIndex - 1, c);
            } else if (a== 2){
                long result = sumValue(b + startNodeIndex - 1,  c + startNodeIndex - 1);
                System.out.println(result);
            }
        }

        br.close();
    }

    private static long sumValue(long start, long end) {

        long sum = 0;
        // 선택
        while (start <= end) {

            if (start % 2 == 1) {
                sum += tree[(int)start];
            }

            if (end % 2 == 0) {
                sum += tree[(int) end];
            }

            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }

        return sum;
    }

    private static void update(long index, long value) {
        long diff = value - tree[(int)index];

        while (index > 0) {
            tree[(int)index] += diff;
            index /= 2;
        }

    }


}
