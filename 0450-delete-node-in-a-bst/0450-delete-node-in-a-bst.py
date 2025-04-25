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
        # root.val > key -> 왼쪽
        if root.val > key:
            root.left = self.deleteNode(root.left, key)
        # root.val < key -> 오른쪽
        elif root.val < key:
            root.right = self.deleteNode(root.right, key)
        # 같으면 자식들 탐방
        else:
            # 리프노드
            if not root.right and not root.left:
                return None
            
            # 자식하나
            if not root.left:
                return root.right
            elif not root.right:
                return root.left
            
            # 자식이 둘
            def findNode(node: TreeNode) -> TreeNode:
                while node.left:
                    node = node.left
                return node
            # 오른쪽 자식중에 제일 작은 애를 root의 val로 만든다.
            result = findNode(root.right)
            root.val = result.val
            root.right = self.deleteNode(root.right, result.val)

        return root
        