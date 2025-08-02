import java.util.*;

class Solution {
    Set<Integer>[] set;
    boolean[] visited;
    int[] answers = new int[5]; // 입력한 정수
    int answer;
    public int solution(int n, int[][] q, int[] ans) {
        // 비밀 코드는 뭔지 모른다
        // 하지만 입력한 정수와 비밀 코드와의 일치관계는 알 수 있다.
        // q = 입력한 정수 배열
        // ans = 일치 개수
        set = new HashSet[q.length];
        visited = new boolean[n+1];
        for (int i=0; i<q.length; ++i) {
            set[i] = new HashSet<>();
            for (int j=0; j<q[0].length; ++j) {
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
            
            for (int a : answers) {
                if (set[i].contains(a)) sum++;
            }
            
            if (sum != ans[i]) return false;
        }
        
        return true;
    }
}