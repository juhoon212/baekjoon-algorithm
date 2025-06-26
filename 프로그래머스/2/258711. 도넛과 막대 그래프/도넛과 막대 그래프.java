import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        // int[] from, to
        HashMap<Integer, int[]> map = new HashMap<>();
        int maxVal = -1;
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            map.putIfAbsent(from, new int[2]);
            map.putIfAbsent(to, new int[2]);
            
            map.get(from)[0]++;
            map.get(to)[1]++;
            
            maxVal = Math.max(maxVal, Math.max(from, to));
        }
        
        int[] answer = new int[4];
        for (int i=1; i<=maxVal; ++i) {
            if (!map.containsKey(i)) continue;
            
            int[] now = map.get(i);
            
            // 정점
            if (now[0] >= 2 && now[1] == 0) answer[0] = i;
            
            // 막대 모양 그래프
            if (now[0] == 0) answer[2]++;
            
            // 8자 모양
            if (now[0] >= 2 && now[1] >= 2) answer[3]++;
        }
        
        // 도넛 모양
        answer[1] = map.get(answer[0])[0] - (answer[2] + answer[3]);
        return answer;
    }
}