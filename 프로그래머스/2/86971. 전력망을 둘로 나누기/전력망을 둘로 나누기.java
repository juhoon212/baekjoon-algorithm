import java.util.*;

class Solution {
    static int n;
    static int [][] wires;

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        this.n = n;
        this.wires = wires;

        A = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        // 양방향
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            A[a].add(b);
            A[b].add(a);
        }

        // 모든 간선에 대해 한 번씩 끊어봄(완전탐색)
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            // 반복문 돌때마다 매번 새롭게 생성
            visited = new boolean[n + 1];

            // 1. 해당 간선을 그래프에서 제거
            A[a].remove(Integer.valueOf(b));
            A[b].remove(Integer.valueOf(a));

            int cnt = dfs(1);
            int diff = Math.abs(cnt - (n - cnt)); // |송전탑 개수 차이 계산| -> 최솟값 갱신
            min = Math.min(min, diff);

            A[a].add(b);
            A[b].add(a);
        }

        return min;
    }

    private int dfs(int value) {
        visited[value] = true;
        int count = 1;

        for (int next: A[value]) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }
        return count;
    }
}