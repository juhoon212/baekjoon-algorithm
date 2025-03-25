class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        set1 = set(nums1)
        set2 = set(nums2)

        list1 = []
        list2 = []
        
        for num in set1:
            if num not in set2:
                list1.append(num)
        
        for num in set2:
            if num not in set1:
                list2.append(num)

        return [list1, list2]