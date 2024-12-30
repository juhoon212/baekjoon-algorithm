
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    // ( 다음에 (가 오면 다음에는 ( 가 올 수 있지만 )가 3개연달아서 나와야한다.
    // 첫째줄에 줄의 개수
    // 문자열 길이는 2 ~ 50

    public static void main(String[] args) throws IOException {

        // 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // Stack 사용
        for (int i=0; i<N; ++i) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            Stack<Character> stack = new Stack<>();

            boolean isEnd = false;

            for (char now : charArray) {
                if (now == '(') {
                    stack.push(now);
                } else {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        isEnd = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!isEnd) {
                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
