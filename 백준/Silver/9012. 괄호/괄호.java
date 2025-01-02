
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {

        // 입력을 받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 스택 LIFO 생성
        // 스택에 '(' 이면 집어넣고 ')' 면 뺀다.
        for (int i=0; i<N; ++i) {
            char[] charArr = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            boolean isEnd = false;
            for (char now : charArr) {
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
