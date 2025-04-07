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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> memo = new ArrayList<>();
        List<Integer> memo2 = new ArrayList<>();
        dfs(root1, memo);
        dfs(root2, memo2);

        if (memo.size() != memo2.size()) {
            return false;
        }

        for (int i=0; i<memo.size(); ++i) {
            if (!memo.get(i).equals(memo2.get(i))) {
                return false;
            }
        }

        return true;
    }

    void dfs(TreeNode node, List<Integer> memo) {
        if (node == null) {
            return;
        }
        // leaf node
        if (node.right == null && node.left == null) {
            memo.add(node.val);
            return;
        }
        
        dfs(node.left, memo);
        dfs(node.right, memo);
    }
}