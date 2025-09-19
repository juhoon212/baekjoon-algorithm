import java.util.*;

class Solution {
    // q = 입력한 정수 배열
    // ans = 몇개 일치하는지 응답 
    int[] temp = new int[5];
    int answer;
    int N;
    Set<Integer>[] set;
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        
        set = new HashSet[q.length];
        for (int i=0; i<q.length; ++i) {
            set[i] = new HashSet<>();
            for (int j=0; j<q[0].length; ++j) {
                set[i].add(q[i][j]);
            }
        }
        
        backTracking(0, 1, q, ans);
        return answer;
    }
    
    void backTracking(int cur, int max, int[][] q, int[] ans) {
        // 탈출 조건
        if (cur == 5) {
            if (check(q, ans)) answer++;
            return;
        }
        
        for (int i=max; i<=N; ++i) {
            temp[cur] = i;
            backTracking(cur+1, i+1, q, ans);
        }
    }
    
    // q를 전체 다 돌면서 temp랑 q[i]랑 비교하면서 같은 갯수가 있으면 세고 그 센 것을 ans[i] 랑 비교해서 전부 맞으면 ans+1
    boolean check(int[][] q, int[] ans) {
        for (int i=0; i<q.length; ++i) {
            int sum = 0;
            for (int t : temp) {
                if (set[i].contains(t)) sum++;
            }
            if (ans[i] != sum) return false;
        }
        return true;
    }
}