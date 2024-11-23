
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int num[];

    static int operator[] = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 숫자 받기
        for (int i=0; i<N; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<4; ++i) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // 백트래킹 (초기값, 숫자갯수를 몇개 쓰는지)
        backTracking(num[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    private static void backTracking(int now, int index) {
        if (index == N) {
            MAX = Math.max(now, MAX);
            MIN = Math.min(now, MIN);
            return;
        }

        // + 선택
        if (operator[0]>0) {
            operator[0]--;
            backTracking(now + num[index], index+1);
            operator[0]++; // 재귀 빠져나올때 복구
        }

        // - 선택
        if (operator[1]>0) {
            operator[1]--;
            backTracking(now - num[index], index+1);
            operator[1]++; // 재귀 빠져나올때 복구
        }

        // * 선택
        if (operator[2]>0) {
            operator[2]--;
            backTracking(now * num[index], index+1);
            operator[2]++; // 재귀 빠져나올때 복구
        }

        // / 선택
        if (operator[3]>0) {
            operator[3]--;
            backTracking(now / num[index], index+1);
            operator[3]++; // 재귀 빠져나올때 복구
        }
    }
}
