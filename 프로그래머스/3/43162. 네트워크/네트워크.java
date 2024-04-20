

public class Solution {

    boolean[] visited;
    int answer = 0;

    public int solution(int n, int[][] computers) {


        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }

    private void dfs(int num, int[][] computers) {

        if (visited[num]) {
            return;
        }

        visited[num] = true;

        final int[] computer = computers[num];

        for (int i = 0; i < computer.length; i++) {
            if (!visited[i] && computer[i] != 0) {
                dfs(i, computers);
            }


        }
    }

    // [1,1,0]
    // [1,1,0]
    // [0,0,1]

}