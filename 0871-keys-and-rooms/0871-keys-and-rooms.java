class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 그래프 탐색
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        dfs(rooms, rooms.get(0), visited);

        for (boolean isVisited : visited) {
            if (!isVisited) return false;
        }
        return true;
    }

    void dfs(List<List<Integer>> rooms, List<Integer> room, boolean[] visited) {
        for (int key : room) {
            if (!visited[key]) {
                visited[key] = true;
                dfs(rooms, rooms.get(key), visited);
            }
        }
    }

    
}