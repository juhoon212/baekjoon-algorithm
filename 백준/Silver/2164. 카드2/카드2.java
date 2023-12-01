
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        // 1234
        // 제일 위에 있는 카드를 버리고 두번쨰 카드를 제일 뒤로 보낸다. FIFO Queue 사용
        // 반복한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            Integer nextpollNum = queue.poll();
            queue.add(nextpollNum);
        }

        System.out.println(queue.poll());
    }
}
