
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {

        // 오름차순 정렬하라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N개의 수
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // 배열에 들어오는 수 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // N - 1 => 맨끝에 가서는 연산을 하지 않으니까.
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i ; j++) {

                if(arr[j] > arr[j + 1]) {
                    // 스왑연산
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }

    }
}
