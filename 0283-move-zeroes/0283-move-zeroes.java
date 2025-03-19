class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int r=0; r<nums.length; ++r) {
            if (nums[r] !=0) {
                // 왼쪽 것이랑 비교
                int tmp = nums[r];
                nums[r] = nums[left];
                nums[left] = tmp;
                

                left++;
                
                

                
            }

            
        }

        
    }
}