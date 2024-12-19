class Solution {
    public int maxSubArray(int[] nums) {
        // nums = [1,-2,3] 라고 가정
        // 지금 더한것과 전에 더한것의 차이를 구해서
        // 만약에 전 value가 더 크다면 멈춘다.
        // 현재 value가 더 크다면 계속한다.

        int totalMax = nums[0];
        int curMax = nums[0];

        for (int i=1; i<nums.length; ++i) {
            curMax = Math.max(nums[i], nums[i] + curMax);
            totalMax = Math.max(totalMax, curMax);
        }
        return totalMax;
    }
}