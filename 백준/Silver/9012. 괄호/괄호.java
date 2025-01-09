
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {

        // 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        // 괄호 문제는 먼저 stack 을 떠올린다.
        for (int i=0; i<T; ++i) {
            char nowArr[] = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            boolean isEnd = false;
            for (char now : nowArr) {
                // '(' 가 들어오면 stack 에 집어넣는다.
                if (now == '(') {
                    stack.push(now);
                } else {
                    // ')' 가 들어오면 stack 이 비어있지 않으면 데이터를 꺼낸다.
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
                // 만약 위 상황에 stack 이 비어있다면 No를 출력한다.
                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }


    }
}
