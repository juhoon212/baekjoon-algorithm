

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 입력받은 수를 배열에 저장
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                int result = arr[end] - arr[start - 1];

                System.out.println(result);
            }
        }
    }
