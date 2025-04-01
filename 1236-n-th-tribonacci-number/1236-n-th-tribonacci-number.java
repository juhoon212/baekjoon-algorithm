class Solution {
    public int tribonacci(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return recursion(n, map);
        
    }

    int recursion(int n, Map<Integer, Integer> memo) {

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result;
        if (n == 0) {
            result =  0;
        } else if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = recursion(n-1, memo) + recursion(n-2, memo) + recursion(n-3, memo);
        }

        memo.put(n, result);
        return result;
    }
}