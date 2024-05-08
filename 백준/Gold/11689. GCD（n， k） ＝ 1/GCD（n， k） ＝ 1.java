
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최대 공약수가 1이 되는 두 수 => 오일러피(서로소의 갯수)

        long n = Long.parseLong(br.readLine());

        long result = n;

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result = result - result / i;
            }

            while (n % i == 0) n = n / i;
        }

        if (n > 1) result = result - result / n;

        System.out.println(result);
    }
}
