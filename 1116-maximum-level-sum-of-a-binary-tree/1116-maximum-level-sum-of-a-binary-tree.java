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
    public int maxLevelSum(TreeNode root) {
        return bfs(root);
    }

    int bfs(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int currentLevel = 1;
        int answerLevel = 1;
        int maxSum = Integer.MIN_VALUE;


        while (!q.isEmpty()) {
            int qSize = q.size();
            int result = 0;
            for (int i=0; i<qSize; ++i) {
                TreeNode now = q.poll();

                result += now.val;

                if (now.left != null) {
                    q.offer(now.left);
                }

                if (now.right != null) {
                    q.offer(now.right);
                }
            }

            if (result > maxSum) {
                maxSum = result;
                answerLevel = currentLevel;
            }

            currentLevel++;
        }

        return answerLevel;
    }
}