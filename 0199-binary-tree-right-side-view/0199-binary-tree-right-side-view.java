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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode right = null;
            int qSize = q.size();
            for (int i=0; i<qSize; ++i) {
                TreeNode now = q.poll(); // 1
                if (now != null) {
                    right = now;
                    q.add(now.left);
                    q.add(now.right);
                }
            }

            if (right != null) {
                list.add(right.val);
            }
        }

        return list;
    }
}