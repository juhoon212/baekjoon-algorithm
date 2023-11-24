import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int sum = 0;
            int max = 0;
            // 입력받은 점수들 입력받을 배열 생성
            int[] scores = new int[n];


            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                sum += scores[i];

                if(max < scores[i]) max = scores[i];
            }

            System.out.println((double)sum/max * 100/n);

        }
    }