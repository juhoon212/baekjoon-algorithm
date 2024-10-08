class Solution {
    int[][] dungeons;
    int k;

    int answer = -1;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {

        this.dungeons = dungeons;
        this.k = k;

        visited = new boolean[dungeons.length];

        dfs(0, k);

        return answer;
    }

    private void dfs(int index, int k) {
        for (int i = 0; i < dungeons.length; ++i) {
            // 탈출
            if (visited[i] || (k < dungeons[i][0])) {
                continue;
            }

            // 실행
            visited[i] = true;
            System.out.println(k - dungeons[i][1]);
            dfs(index + 1, k - dungeons[i][1]);
            visited[i] = false;
        }

        answer = Math.max(answer, index);
    }
}