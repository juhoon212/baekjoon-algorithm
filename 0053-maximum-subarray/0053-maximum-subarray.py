class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_value = nums[0]
        cur_sum = 0

        for i in nums:
            if cur_sum < 0:
                cur_sum = 0
            cur_sum += i
            
            max_value = max(max_value, cur_sum)
        return max_value
            

        

            

                
        