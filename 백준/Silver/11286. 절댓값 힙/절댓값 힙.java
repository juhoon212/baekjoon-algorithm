
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {

        // 배열에 들어오는값이 0 이 아니라면 배열에 추가
        // 0 이라면 절대값이 가장 작은 값 출력 후 배열에서 제거

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {

            int num1 = Math.abs(o1);
            int num2 = Math.abs(o2);

            if(num1 == num2) {
                return o1 > o2 ? 1 : -1;
            }

            return num1 - num2;
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(priorityQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(priorityQueue.poll());
                }
            } else {
                priorityQueue.add(x);
            }
        }

    }
}
