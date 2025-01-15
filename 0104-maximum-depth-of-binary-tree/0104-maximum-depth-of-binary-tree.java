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
    public int maxDepth(TreeNode root) {
        int maxDepth = maxDepthPrivate(root, 0);

        return maxDepth;
    }

    private int maxDepthPrivate(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(maxDepthPrivate(node.left, depth + 1), maxDepthPrivate(node.right, depth + 1));
    }
}