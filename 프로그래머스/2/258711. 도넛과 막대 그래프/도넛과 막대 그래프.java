import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int [] answer = new int[4];
        HashMap <Integer, int[]> graph = new HashMap<>();
        int maxNode = -1;
        
        for(int [] now : edges) {
            int from = now[0];
            int to = now[1];
            graph.putIfAbsent(from, new int[2]);
            graph.putIfAbsent(to, new int[2]);
            graph.get(from)[0]++;
            graph.get(to)[1]++;
            maxNode = Math.max(maxNode, Math.max(from, to));
        }
        
        for(int i=1;i<=maxNode; i++){
            if (!graph.containsKey(i)) {
                continue;
            }
            
            int [] now = graph.get(i);
            
            //생성점 구하기
            if (now[0] >= 2 && now[1] == 0) {
                answer[0]=i;
            }
            //막대 그래프 구하기
            else if(now[0]==0) {
                answer[2]++;
            }
            //8자 그래프 구하기
            else if (now[0] >= 2 && now[1] >= 2) {
                answer[3]++;
            }
        }
        
        answer[1] = graph.get(answer[0])[0] - (answer[2]+answer[3]);
         
        return answer;
    }
}