import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int cnt = 0; // 증설 횟수
        
        Queue<Integer> q = new ArrayDeque<>();
        
        // 24시간 동안
        for (int i=0; i<24; ++i) {
            int need = players[i] / m;
            
            while (!q.isEmpty() && q.peek() <= i) q.poll();
            
            int current = q.size();
            
            if (need > current) {
                int newServerNeed = need - current;
                cnt += newServerNeed;
                for (int j=0; j<newServerNeed; ++j) {
                    q.add(i + k);
                }
            }
        }
        
        return cnt;
    }
}