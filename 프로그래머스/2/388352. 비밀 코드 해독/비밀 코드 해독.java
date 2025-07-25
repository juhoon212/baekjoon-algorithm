import java.util.*;

class Solution {
    int[] answers = new int[5];
    Set<Integer>[] set;
    boolean[] visited;
    int answer;
    public int solution(int n, int[][] q, int[] ans) {
        set = new HashSet[q.length];
        visited = new boolean[n+1];
        
        for (int i=0; i<q.length; ++i) {
            set[i] = new HashSet<>();
            for (int j=0; j<5; ++j) {
                set[i].add(q[i][j]);
            }
        }
        
        makeArr(0, 1, n, q, ans);
        return answer;
    }
    
    void makeArr(int cnt, int cur, int n, int[][] q, int[] ans) {
        if (cnt == 5) {
            if (check(q, ans)) answer++;
            return;
        }
        
        for (int i=cur; i<=n; ++i) {
            if (visited[i]) continue;
            answers[cnt] = i;
            
            visited[i] = true;
            makeArr(cnt+1, i+1, n, q, ans);
            visited[i] = false;
        }
    }
    
    boolean check(int[][] q, int[] ans) {
        for (int i=0; i<q.length; ++i) {
            int sum = 0;
            
            for (int num : answers) {
                if (set[i].contains(num)) sum++;
            }
            
            if (ans[i] != sum) return false;
        }
        
        return true;
    }
}