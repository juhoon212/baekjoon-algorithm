

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 그리디 알고리즘

        int count = 0;
        //가장 큰 동전부터 선택
        for (int i = N - 1; i >= 0 ; i--) {
            if(arr[i] <= K) {
                count += K / arr[i];
                K = K % arr[i];
            }
        }

        System.out.println(count);

    }
}