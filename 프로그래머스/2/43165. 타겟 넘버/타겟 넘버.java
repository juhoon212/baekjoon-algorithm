
public class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {

        dfs(0, 0, numbers, target);

        return answer;
    }

    private void dfs(int sum, int depth, int[] numbers, int target) {

        if (depth == numbers.length && sum == target) {
            answer++;
            return;
        }

        if (depth >= numbers.length) {
            return;
        }

        dfs(sum + numbers[depth],depth + 1, numbers, target);
        dfs(sum - numbers[depth], depth + 1, numbers, target);
    }

//    public static void main(String[] args) {
//        타겟넘버 ex = new 타겟넘버();
//        final int solution = ex.solution(new int[]{4,1,2,1}, 4);
//        System.out.println(solution);
//    }
}
