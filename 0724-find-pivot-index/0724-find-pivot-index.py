class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        leftSum = 0
        totalSum = sum(nums)

        for index, element in enumerate(nums):
            if leftSum == (totalSum - element - leftSum):
                return index
            leftSum += element
        
        return -1