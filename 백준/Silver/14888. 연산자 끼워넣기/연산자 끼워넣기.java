
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int num[];
    static int operator[];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{

        // 수열

        // 첫째줄: 숫자의 갯수
        // 둘째줄: 숫자
        // 셋째줄 연산자의 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 숫자 배열 세팅
        for (int i=0; i<N; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        // 연산자 배열 세팅
        operator = new int[4];
        for (int i=0; i<4; ++i) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        
        backTracking(num[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
        
    }
    
    private static void backTracking(int now, int index) {
        // 탈출 조건
        if (index == N) {
            MAX = Math.max(MAX, now);
            MIN = Math.min(MIN, now);
            return;
        }
        
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
