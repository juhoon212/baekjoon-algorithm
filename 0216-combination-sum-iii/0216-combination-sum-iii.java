class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // k 개의 개수가 됬을 때 n이 되면 list에 담는다.
        List<List<Integer>> answers = new ArrayList<>();
        backTrack(1, k, n, new ArrayList<>(), answers);
        return answers;
    }   
    void backTrack(
        int start, 
        int k, 
        int n, 
        List<Integer> answer, 
        List<List<Integer>> answers
    ) {
        // 탈출 조건
        if (answer.size() == k && n == 0) {
            List<Integer> temp = new ArrayList<>(answer);
            answers.add(temp);
            return;
        }

        for (int i=start; i<=9; ++i) {
            answer.add(i);
            backTrack(i+1, k, n-i, answer, answers);
            answer.remove(answer.size()-1);
        }    
    }
}