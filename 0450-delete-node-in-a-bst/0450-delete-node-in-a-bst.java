/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val < key) {
            root.right = deleteNode(root.right, key); // 재귀로 오른쪽을 찾는다.
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else { // key == root.val
            // 리프노드
            if (root.left == null && root.right == null) {
                return null;
            }

            // 하나의 노드만 자식으로 가지고 있을 때
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // 이진 트리일때
            TreeNode result = findNode(root.right);
            root.val = result.val;
            root.right = deleteNode(root.right, result.val);
        }

        return root;
    }

    private TreeNode findNode(TreeNode node) { 
        while (node.left != null) { 
            node = node.left;
        }
        return node;
    }
}