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

        if (root == null) {
            return maxDepth;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i=0; i<qSize; ++i) {
                TreeNode now = q.poll();

                if (now.left != null) {
                    q.offer(now.left);
                }

                if (now.right != null) {
                    q.offer(now.right);
                }
            }

            maxDepth++; // 
        }
        return maxDepth;
    }
}