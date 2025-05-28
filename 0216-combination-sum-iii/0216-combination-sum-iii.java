class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answers = new ArrayList<>();  
        backTrack(answers, new ArrayList<Integer>(), k, 1, n); 
        return answers;
    }

    void backTrack(
        List<List<Integer>> answers, 
        List<Integer> answer, 
        int k, 
        int start, 
        int n
    ) {
        if (answer.size() == k && n == 0) {
            List<Integer> temp = new ArrayList<>(answer);
            answers.add(temp);
            return;
        }

        for (int i=start; i<=9; ++i) {
            answer.add(i);
            backTrack(answers, answer, k, i+1, n-i);
            answer.remove(answer.size()-1);
        }
    }
}