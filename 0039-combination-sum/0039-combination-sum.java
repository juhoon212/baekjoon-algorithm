import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, 0, target, candidates, new ArrayList<Integer>(), result);
        return result;
    }

    void dfs(int start, int sum, int target, int[] candidates, List<Integer> current, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i=start; i<candidates.length; ++i) {
            current.add(candidates[i]);
            sum += candidates[i];
            dfs(i, sum, target, candidates, current, result);
            sum -= candidates[i];
            current.remove(current.size()-1);
        }
    }
}