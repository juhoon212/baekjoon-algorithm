class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        visited[0] = true;
        bfs(rooms.get(0), rooms, visited);
        
        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false;
            }
        }
        
        return true;
    }

    public void bfs(List<Integer> keys, List<List<Integer>> rooms, boolean[] visited) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(keys);
        
        while(!q.isEmpty()) {
            final List<Integer> poll = q.poll();
            
            for (int key : poll) {
                if (!visited[key]) {
                    q.offer(rooms.get(key));
                    visited[key] = true;
                }
            }
        }
    }
}