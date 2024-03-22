import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // n일때
        // n-1
        // n-2 ... n
        long[] dp = new long[1001];

        dp[1] = 1;
        dp[2] = 2;

        // 점화식
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
