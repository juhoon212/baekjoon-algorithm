

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {


    public static void main(String[] args) throws IOException {

        // 첫째줄에 자리수를 내림차순 정렬하라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int arr[] = new int[N.length()];

        for (int i = 0; i < N.length(); i++) {
            arr[i] = Integer.parseInt(N.substring(i, i + 1));
        }

        // 선택정렬
        for (int i = 0; i < N.length(); i++) {
            int max = i; // 최댓값
            for (int j = i + 1; j < N.length(); j++) {
                if(arr[j] > arr[max]) {
                    max = j;
                }
            }
            //swap
            if(arr[i] < arr[max]) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }

        for (int i = 0; i < N.length(); i++) {
            System.out.print(arr[i]);
        }


    }
}
