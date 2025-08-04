import java.util.*;

class Solution {
    int[] code = new int[5]; // 비밀 코드
    int answer;
    Set<Integer>[] set;
    public int solution(int n, int[][] q, int[] ans) {
        // 1~n 
        // m 번의 시도
        // 정수 조합
        set = new HashSet[q.length];
        for (int i=0; i<q.length; ++i) {
            set[i] = new HashSet<>();
            for (int j=0; j<q[0].length; ++j) {
                set[i].add(q[i][j]);
            }
        }
        makeAnswer(0, 1, n, q, ans);
        return answer;
    }
    
    void makeAnswer(int cnt, int cur, int n, int[][] q, int[] ans) {
        if (cnt == 5) {
            if (check(q, ans)) answer++;
            return;
        }
        
        for (int i=cur; i<=n; ++i) {   
            code[cnt] = i;
            makeAnswer(cnt+1, i+1, n, q, ans);
        }
    }
    
    boolean check(int[][] q, int[] answer) {
        for (int i=0; i<q.length; ++i) {
            int total = 0;
            
            for (int now : code) {
                if (set[i].contains(now)) total++;
            }
            
            if (total != answer[i]) return false;
        }
        
        return true;
    }
}