import java.util.*;

class Solution {
    int n;
    int[][] wires;
    ArrayList<Integer>[] tree;

    boolean visited[];

    int min = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        init(n, wires);
        // 트리 형태로 되어있다.
        // 트리 초기화 -> 1 ~ 9 => wires 안에 들어있는 수가 1~9
        for (int i = 1; i <= n; ++i) {
            tree[i] = new ArrayList<>();
        }

        // 인접리스트 (양방향 그래프)
        for (int i = 0; i < wires.length; ++i) {
            int a = wires[i][0];
            int b = wires[i][1];

            tree[a].add(b);
            tree[b].add(a);
        }

        for (int i = 0; i < wires.length; ++i) {
            // 1 부터 계속 edge 를 끊으면서 완전 탐색.
            int a = wires[i][0];
            int b = wires[i][1];

            // 방문 배열도 0 ~ 9 까지니까 10으로 세팅
            visited = new boolean[n + 1];

            // edge 끊어준다.
            // remove(Object) 라서 Wrapper 클래스로 변환
            tree[a].remove(Integer.valueOf(b));
            tree[b].remove(Integer.valueOf(a));

            // 1부터 시작
            int result = dfs(1);
            // 잘라진 두 노드가 제일 비슷한 값을 찾는다.(절대값)
            int diff = Math.abs(result - (n - result));
            min = Math.min(min, diff);
            
            // 복구
            tree[a].add(b);
            tree[b].add(a);
        }

        return min;
    }

    // 탐색 dfs
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
        this.tree = new ArrayList[n + 1]; // 10
    }
}