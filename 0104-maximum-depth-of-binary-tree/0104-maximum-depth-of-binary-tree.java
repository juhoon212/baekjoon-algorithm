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
        int maxDepth = 0;

        if (root == null) return maxDepth;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i=0; i<qSize; ++i) {
                TreeNode now = q.poll();
                
                if (now.left != null) {
                    q.add(now.left);
                }

                if (now.right != null) {
                    q.add(now.right);
                }
            }

            maxDepth++;
        }

        return maxDepth;
    }
}