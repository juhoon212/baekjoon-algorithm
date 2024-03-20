

import java.util.Scanner;

public class Main {

    static int[] DP;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DP = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            DP[i] = -1; // 초기화
        }

        DP[0] = 0;
        DP[1] = 1;

        fibo(n);
        System.out.println(DP[n]);
    }

    private static int fibo(int num) {
        // 계산된 함수
        if (DP[num] != -1) {
            return DP[num];
        }

        return DP[num] = fibo(num - 1) + fibo(num - 2);
    }

}
