import java.util.*;
import java.io.*;

class Main {
    static int[] answer;
    static int N;
    static int result=0;
    public static void main(String[] args) throws Exception {
        // N만큼의 Queen을 배치해야한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(Integer.parseInt(br.readLine()));
        
        backTracking(0); // 조합
        System.out.println(result);
    }
    
    static void init(int n) {
        N = n;
        answer = new int[n];
    }
    
    static void backTracking(int col) {
        if (col == N) { // 모든 열을 다돌았다. 즉 모든 queen이 가질 수 있는 조합을 완성시켰다.
            result++;
            return;
        }
        
        for (int i=0; i<N; ++i) {
            answer[col] = i;
            
            if (check(col)) {
                backTracking(col+1);
            }
        }
    }
    
    // Queen이 현재 같은 행에 있거나, 대각선에 있는지 확인
    static boolean check(int col) {
        for (int i=0; i<col; ++i) {
            if (answer[i] == answer[col]) return false;
            if (Math.abs(i - col) == Math.abs(answer[i] - answer[col])) return false;
        }
        
        return true;
    }
}