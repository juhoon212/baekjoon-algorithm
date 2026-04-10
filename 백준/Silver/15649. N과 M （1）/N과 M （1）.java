import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        String[] s = line.split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        visited = new boolean[N];
        
        // 1~N까지 M개를 순열로 뽑아야함
        int[] arr = new int[M];
        dfs(0, arr);
    }
    
    static void dfs(int depth, int[] arr) {
        if (depth == M) {
            for (int value: arr) {
                System.out.print(value + " " );
            }
            
            System.out.println();
            return;
        }
        
        for (int i=0; i<N; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                dfs(depth+1, arr);
                visited[i] = false;
            }
        }
    }
}