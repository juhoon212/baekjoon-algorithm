
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // TODO 다시 풀기

    public static void main(String[] args) throws IOException {

        // 거의 소수 : 소수의 N제곱,  N >= 2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long arr[] = new long[10000001];

         long a = Long.parseLong(st.nextToken());
         long b = Long.parseLong(st.nextToken());

        // 소수 저장
        for (int i = 2; i < 10000001; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(10000001); i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = i + i; j < 10000001; j = i + j) {
                arr[j] = 0;
            }
        }

        int count = 0;
        //거의 소수 구하기
        for (int i = 2; i < 10000001; i++) {
            if (arr[i] != 0) {
                long temp = arr[i];
                while ((double)arr[i] <= (double) b / (double) temp) {
                     if ((double)arr[i] >= (double)a / (double) temp) {
                         count++;
                     }
                    temp = temp * arr[i];
                }
            }
        }

        System.out.println(count);
    }
}
