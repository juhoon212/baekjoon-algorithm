# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def maxDepth(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        max_depth = 0

        if (root is None):
            return max_depth
        q = deque()
        q.append((root,1))

        while q:
            now, now_depth = q.popleft()
            max_depth = max(now_depth, max_depth)

            if now.left:
                q.append((now.left, now_depth + 1))
            
            if now.right:
                q.append((now.right, now_depth + 1))
        
        return max_depth

        