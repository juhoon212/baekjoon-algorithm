import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /**
     * N킬로그램을 배달해야 하는데
     * 3kg, 5kg 짜리가 있다.
     * 최소 갯수를 구해라
     * 단 정확하게 들수 없다면 -1을 출력한다.
     */

    public static void main(String[] args) throws Exception{

        // 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 만약 5의 배수로 나눈 나머지가 3으로 나누어 떨어진다면 출력한다.
        int count = N / 5;
        N %= 5;
        if (N == 0) {
            System.out.println(count);
            return;
        }
        // 아니라면 3의 배수로 나눈 나머지가 5로 나누어 떨어진다면 출력한다.
        for (int i=0; i<3 && count-i>=0; ++i) {
            int temp = N + 5 * i;

            if (temp%3==0) {
                count -= i;
                count += temp / 3;
                System.out.println(count);
                return;
            }
        }
        System.out.println(-1);

    }
}
