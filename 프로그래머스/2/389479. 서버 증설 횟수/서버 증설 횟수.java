import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i=0; i<24; ++i) {
            int need = players[i] / m;
            
            while (!q.isEmpty() && q.peek() <= i) {
                q.poll();
            }
            
            int current = q.size();
            
            if (need > current) {
                int newServer = need - current;
                cnt += newServer;
                for (int j=0; j<newServer; ++j) {
                    q.add(i + k);
                }
            }
        }
        return cnt;
    }
}