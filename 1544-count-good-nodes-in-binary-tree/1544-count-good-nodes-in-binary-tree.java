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
    int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        // root노드에서 가는길에 도착지 노드보다 큰게 있으면 안됨
        dfs(root, root.val);
        return goodNodes;
    }

    void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }

        if (node.val >= max) {
            goodNodes++;
            max = node.val;
        }

        dfs(node.left, max);
        dfs(node.right, max);
    }
}