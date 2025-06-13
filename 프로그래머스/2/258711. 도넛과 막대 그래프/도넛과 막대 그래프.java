import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        HashMap<Integer, int[]> graph = new HashMap<>();
        
        // 최대 값을 왜 구하는거지?
        int maxValue = -1;
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            graph.putIfAbsent(from, new int[2]);
            graph.putIfAbsent(to, new int[2]);
            
            graph.get(from)[0]++;
            graph.get(to)[1]++;
            
            maxValue = Math.max(maxValue, Math.max(from, to));
        }
        
        int[] answer = new int[4];
        
        for (int i=1; i<=maxValue; ++i) {
            if (!graph.containsKey(i)) {
                continue;
            }
            
            int[] now = graph.get(i);
            
            // 생성점
            if (now[0] >= 2 && now[1] == 0) {
                answer[0] = i;
            }
            
            // 막대 모양 그래프
            if (now[0] == 0) {
                answer[2]++;
            }
            
            if (now[0] >= 2 && now[1] >= 2) {
                answer[3]++;
            }
        }
        
        answer[1] = graph.get(answer[0])[0] - (answer[2] + answer[3]);
        
        return answer;
    }
}