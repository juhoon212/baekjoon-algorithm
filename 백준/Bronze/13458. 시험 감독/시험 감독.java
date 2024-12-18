
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // N개의 시험장이 존재.
    // i번 시험장에 있는 응시자 수는 Ai 명
    // 감독관: - 총감독: 시험장에 1명
    //       - 부감독: 여러명 가능
    // 각 시험장마다 응시생 모두 감시. 이때 필요한 감독관수의 최솟값 구하기!!
    public static void main(String[] args) throws Exception {
        // 1번쨰 줄: 시험장 개수 N
        // 2번째 줄: 응시자 수 Ai
        // 3번째 줄: B,C

        // 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long result = N;

        // 응시자수에서 총감독을 뺀 숫자에서 나머지연산과 MOD 연산을 한다.
        // MOD 연산 시 나머지가 0이상이면 나머지연산한 몫의 값에다가 +1을 해준다.
        for (int i=0; i<N; ++i) {
            int remain = A[i] - B;
            if (remain>0) {
                result += remain / C;
                if (remain%C != 0) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
