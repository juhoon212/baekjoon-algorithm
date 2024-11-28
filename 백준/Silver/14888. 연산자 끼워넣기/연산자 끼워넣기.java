
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // N개의 수열 A1, A2, ... AN
    // 연산자 N - 1개
    // 주어진 수의 순서 바꾸기 x

    static int N;
    static int num[];
    static int operator[];

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 수열 받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        num = new int[N];
        for (int i=0; i<N; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 받기
        // 차례대로 +, -, *, /
        st = new StringTokenizer(br.readLine(), " ");
        operator = new int[4];
        for (int i=0; i<4; ++i) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // 백트래킹 완전탐색
        backTracking(num[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);


    }

    private static void backTracking(int now, int index) {
        // 탈출 조건
        if (index == N) {
            MAX = Math.max(now, MAX);
            MIN = Math.min(now, MIN);
        }

        // 연산자 마다 연산하고 갯수를 하나씩 줄여준다 그리고 재귀에서 백트래킹할때 다시 원래
        // 값으로 복구한다.
        if (operator[0] > 0) {
            operator[0]--;
            backTracking(now + num[index], index + 1);
            operator[0]++;
        }

        if (operator[1] > 0) {
            operator[1]--;
            backTracking(now - num[index], index + 1);
            operator[1]++;
        }

        if (operator[2] > 0) {
            operator[2]--;
            backTracking(now * num[index], index + 1);
            operator[2]++;
        }

        if (operator[3] > 0) {
            operator[3]--;
            backTracking(now / num[index], index + 1);
            operator[3]++;
        }
    }
}
