import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        queen(0);
        System.out.println(answer);
    }
    
    public static void queen(int depth) {
        if (depth == N) {
            answer++;
            return;
        }
        
        // queen은 같은 행, 열, 대각선에 배치할 수 없다.
        for (int i=0; i<N; ++i) {
            arr[depth] = i;
            if (check(depth)) {
                queen(depth + 1);
            }
        }
    }
    
    public static boolean check(int col) {
        for (int i=0; i<col; ++i) {
            if (arr[col] == arr[i]) return false;
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }
}