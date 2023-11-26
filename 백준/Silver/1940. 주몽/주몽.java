

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 갯수

            st = new StringTokenizer(br.readLine());
            int sum = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr); // O(nlogn)

            int startIdx = 0;
            int endIdx = N - 1;
            int count = 0;

            while (startIdx < endIdx){
                if (arr[startIdx] + arr[endIdx] < sum) {
                    startIdx++;
                } else if (arr[startIdx] + arr[endIdx] > sum) {
                    endIdx--;
                } else {
                    count++;
                    startIdx++;
                    endIdx--;
                }
            }

            System.out.println(count);

        }
    }
