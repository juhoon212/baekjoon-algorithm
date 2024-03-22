
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num = new int[N + 1];
        int[] prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        // 배열에 5,4,3,2,1 저장
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + num[i];
        }



        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(prefixSum[end] - prefixSum[start - 1]);
        }

        br.close();
    }
}
