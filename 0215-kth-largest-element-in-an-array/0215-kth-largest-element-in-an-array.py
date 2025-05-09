class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        max_heap = []

        for i in nums:
            heapq.heappush(max_heap, -i)
        
        for i in range(1, k):
            heapq.heappop(max_heap)

        return -heapq.heappop(max_heap)
