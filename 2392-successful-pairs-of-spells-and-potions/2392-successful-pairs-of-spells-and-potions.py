class Solution(object):
    def successfulPairs(self, spells, potions, success):
        """
        :type spells: List[int]
        :type potions: List[int]
        :type success: int
        :rtype: List[int]
        """
        potions.sort()
        result = []
        for spell in spells:
            l, r = 0, len(potions)-1
            idx = len(potions)
            while l <= r:
                mid = (l + r) // 2
                if spell * potions[mid] >= success:
                    r = mid-1
                    idx = mid
                else:
                    l = mid+1
            
            result.append(len(potions) - idx)
        
        return result
                
        