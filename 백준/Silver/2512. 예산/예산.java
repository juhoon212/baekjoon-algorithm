
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] derivedPay;

    static int max, total;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        max = 0;
        derivedPay = new int[N];

        for (int i = 0; i < N; i++) {
            derivedPay[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, derivedPay[i]);
            total += derivedPay[i];
        }

        M = Integer.parseInt(br.readLine());

        if (total < M) {
            System.out.println(max);
            return;
        }

        int start = 0;
        int end = max;
        int result = 0;
        while (start <= end) {

            int mid = (start + end) / 2;
            int sum = 0;
            for (int pay : derivedPay) {

                if (pay >= mid) {
                    sum += mid;
                } else {
                    sum += pay;
                }
            }

            if (sum > M) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = Math.max(result, mid);
            }
        }

        System.out.println(result);

    }
}
