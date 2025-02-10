class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean isVisited[] = new boolean[rooms.size()];
        isVisited[0] = true;
        dfs(rooms.get(0), rooms, 0, isVisited);

        for (boolean visited : isVisited) {
            if (!visited) {
                return false;
            }
        }

        return true;
    }

    private void dfs(
            List<Integer> keys,
            List<List<Integer>> rooms,
            int index,
            boolean[] visited) {

        visited[index] = true;

        for (int key : keys) {
            if (!visited[key]) {
                dfs(rooms.get(key), rooms, key, visited);
            }
        }
    }
}