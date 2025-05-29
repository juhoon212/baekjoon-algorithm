class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answers = new ArrayList<>();
        backTrack(1, k, n, new ArrayList<>(), answers);
        return answers;
    }   

    void backTrack(int idx, int k, int n, List<Integer> answer, List<List<Integer>> answers) {
        if (answer.size() == k && n == 0) {
            List<Integer> temp = new ArrayList<>(answer);
            answers.add(temp);
            return;
        }

        for (int i=idx; i<=9; ++i) {
            // 뭘 할거야?
            answer.add(i);
            backTrack(i+1, k, n-i, answer, answers);
            answer.remove(answer.size() - 1);
        }
    }
}