class Solution {
    public int maxOperations(int[] nums, int k) {
        // nums에서 합이 k인 수 2개를 꺼낸다.
        // count++

        int start = 0;
        int end = nums.length-1;
        int count = 0;

        Arrays.sort(nums);

        while (start < end) {
            if (nums[start] + nums[end] == k) {
                start++;
                end--;
                count++;
            } else if (nums[start] + nums[end] < k) {
                start++;
            } else {
                end--;
            }
        }

        return count;
    }
}