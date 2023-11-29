
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int num = 1;

        for (int i = 0; i < N; i++) { // 배열에 들어오는 수 저장
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        boolean result = true;

        for (int i = 0; i < arr.length; i++) {
            int arrNum = arr[i];
            if (num <= arrNum) { // 배열안에 들어있는 수보다 num이 작거나 같을때
                while (num <= arrNum) {
                    stack.push(num);
                    num++; // 1씩 증가
                    sb.append("+\n");
                }
                stack.pop(); // 하나 더 많게되는 경우
                sb.append("-\n");
            } else {
                Integer output = stack.pop();
                if (output > arrNum) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }

        if(result) System.out.println(sb.toString());
    }
}
