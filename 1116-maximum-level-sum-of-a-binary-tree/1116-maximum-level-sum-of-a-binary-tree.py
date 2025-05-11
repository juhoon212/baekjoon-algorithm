# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        q = deque()
        q.append(root)

        cur_level = 1
        answer = 0
        max_sum = float('-inf')      
        while q:
            q_size = len(q)
            sum = 0
            for i in range(len(q)):
                node = q.popleft()
                sum += node.val

                if node.left:
                    q.append(node.left)
                
                if node.right:
                    q.append(node.right)

            if sum > max_sum:
                max_sum = sum
                answer = cur_level
            
            cur_level += 1
        return answer
        
        

                    
                


        
        
        