import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int total = 0;
        int[] expire = new int[24 + k + 1]; // 특정 시간대에 몇대의 서버증설을 했나?
        int active = 0; // 현재 증설된 서버의 수
        
        for (int i=0; i<24; ++i) {
            // 시간 초과된 서버의 증설 제거
            if (expire[i] > 0) active -= expire[i]; 
            int need = players[i] / m; // ?
            int add = Math.max(0, need - active);
            
            if (add > 0) {
                total += add;
                active += add;
            }
            
            int endTime = i + k;
            if (endTime < expire.length) expire[endTime] += add;
        }
        
        return total;
    }
}