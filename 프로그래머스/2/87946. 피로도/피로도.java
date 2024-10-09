class Solution {
    int k;
    int[][] dungeons;

    boolean[] visited;
    int answer = -1;

    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        
        visited = new boolean[dungeons.length];
        
        dfs(0, k);

        return answer;
    }

    private void dfs(int index, int k) {
        for (int i = 0; i < dungeons.length; ++i) {
            // 탈출
            // 방문했거나 && 최소 피로도보다 작을 때
            if (visited[i] || (k < dungeons[i][0])) {
                continue;
            }
            // 실행 코드
            visited[i] = true;
            dfs(index + 1, k - dungeons[i][1]);
            visited[i] = false;
        }

        answer = Math.max(answer, index);
    }

   
}