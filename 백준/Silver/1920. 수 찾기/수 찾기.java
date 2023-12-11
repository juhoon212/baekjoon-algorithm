

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];


        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = arr.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                int midVal = arr[mid];
                if(midVal > target) {
                    end = mid - 1;
                } else if(midVal < target) {
                    start = mid + 1;
                } else {
                    find = true;
                    break;
                }
            }

            if(find) System.out.println(1);
            else System.out.println(0);
        }
    }
}