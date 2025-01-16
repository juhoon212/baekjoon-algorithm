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

        // 큐를 생성하고 노드를 넣는다.
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // 큐를 반복하면서 큐의 사이즈만큼 돌린다. 뭐를?
        // 큐에 들어있는 노드들을

        while (!q.isEmpty()) {
            // 큐의 사이즈를 측정한다.
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

            maxDepth++;
        }

        return maxDepth;
    }
}