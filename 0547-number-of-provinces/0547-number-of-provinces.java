class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int result = 0;
        for (int i=0; i<n; ++i) {
            if (!visited[i]) {
                result++;
                dfs(isConnected, visited, i);
            }
        }
        return result;
    }

    void dfs(int[][] isConnected, boolean[] visited, int num) {
        visited[num] = true; // 방문

        for (int i=0; i<isConnected.length; ++i) {
            if (!visited[i] && isConnected[num][i] == 1) {
                dfs(isConnected, visited, i);
            }
        }
    } 
}