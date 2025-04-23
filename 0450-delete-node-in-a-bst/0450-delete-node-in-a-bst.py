# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return None
        
        if root.val > key:
            root.left = self.deleteNode(root.left, key)
        elif root.val < key:
            root.right = self.deleteNode(root.right, key)
        else :
            if not root.left and not root.right:
                return None
            
            # 자식이 하나
            if not root.left:
                return root.right
            elif not root.right:
                return root.left
            
            # 완전 이진 트리
            def findNode(node: TreeNode) -> TreeNode:
                while node.left:
                    node = node.left
                return node

            result = findNode(root.right)
            root.val = result.val
            root.right = self.deleteNode(root.right, result.val)

        return root
        