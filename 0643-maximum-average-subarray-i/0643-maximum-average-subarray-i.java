class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = 0.0;
        int startIdx = 0;
        int endIdx = k;
        int sum = 0; 

        for (int i=0; i<k; ++i) {
            sum += nums[i];
        }
        result = sum;

        while (endIdx < nums.length) {
            sum -= nums[startIdx];
            sum += nums[endIdx];
            startIdx++;
            endIdx++;
            result = Math.max(result, sum);
        }
        return result/k;
    }
}