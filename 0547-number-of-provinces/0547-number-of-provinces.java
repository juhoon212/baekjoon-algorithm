class Solution {
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; ++i) {
            if (!visited[i]) {
                result++;
                dfs(isConnected, visited, i);
            }
        }
        return result;
    }

    void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;

        for (int i=0; i<isConnected.length; ++i) {
            if (!visited[i] && isConnected[node][i] == 1) {
                dfs(isConnected, visited, i);
            }
        }
    }

    
}