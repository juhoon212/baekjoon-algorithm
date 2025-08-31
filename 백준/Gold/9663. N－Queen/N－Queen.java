import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static int[] map;
    static int answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        
        backTracking(0);
        System.out.println(answer);
    }
    
    static void backTracking(final int row) {
        // 탈출 조건
        if (row == N) {
            answer++;
            return;
        }     
        
        for (int i=0; i<N; ++i) {
            map[row] = i;
            if (check(row)) {
                backTracking(row+1);
            }
        }
    }
    
    static boolean check(int row) {
        for (int i=0; i<row; ++i) {
            if (map[row] == map[i]) return false; // 같은 열에 배치시
            if ((Math.abs(map[row] - map[i])) == Math.abs(row - i)) return false;
        } 
        return true;
    }
}