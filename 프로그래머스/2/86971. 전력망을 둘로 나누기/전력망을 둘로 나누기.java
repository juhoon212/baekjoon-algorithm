import java.util.*;

class Solution {
     int n;
    int[][] wires;
    
    // 계속 초기화
    boolean[] visited;
    List<Integer>[] tree;

    int min = Integer.MAX_VALUE;
    
    
    public int solution(int n, int[][] wires) {
        // 트리 형태로 되어있다.
        init(n, wires);
        // 트리 초기화
        for (int i = 1; i <= n; ++i) {
            tree[i] = new ArrayList<>();
        }
        // 양방향? 단방향? 
        for (int i = 0; i < wires.length; ++i) {
            int a = wires[i][0];
            int b = wires[i][1];

            tree[a].add(b);
            tree[b].add(a);
        }

        // 전선 하나를 끊는다. -> edge 하나를 끊는다.
        for (int i = 0; i < wires.length; ++i) {
            visited = new boolean[n + 1];
            
            int a = wires[i][0];
            int b = wires[i][1];
            
            // edge 삭제
            tree[a].remove(Integer.valueOf(b));
            tree[b].remove(Integer.valueOf(a));
            // 1부터 순회
            int result = dfs(1);

            // 송전탑 즉 노드의 갯수가 가능한 비슷하도록 나눈다.
            // 송전탑 그룹 1 - 송전탑 그룹 2 -> 의 절대값이 제일작은것
            int diff = Math.abs(result - (n - result));
            min = Math.min(min, diff);
            
            // 원상 복구
            tree[a].add(b);
            tree[b].add(a);
        }
        
        return min;
    }
    
    private int dfs(int value) {
        
        visited[value] = true;
        int count = 1;
        for (int next : tree[value]) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }
        
        return count;
    }
    
    private void init(int n, int[][] wires) {
        this.n = n;
        this.wires = wires;
        // visited 계속 초기화
        tree = new ArrayList[n + 1];
    }
}