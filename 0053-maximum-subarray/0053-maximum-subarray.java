class Solution {
      public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }

            currentSum += num;
            maxValue = Math.max(currentSum, maxValue);
        }

        return maxValue;
    }
}