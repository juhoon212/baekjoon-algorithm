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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();

        if (root == null) return answer;

        dfs(root, answer, new StringBuilder());
        return answer;
    }

    void dfs(TreeNode node, List<String> answer, StringBuilder sb) {
        if (node == null) {
            return;
        }
        
        int len = sb.length();
        sb.append(node.val);
        
        if (node.left == null && node.right == null) {
            answer.add(sb.toString());
        } else {
            sb.append("->");
            dfs(node.left, answer , sb);
            dfs(node.right, answer, sb);
        }

        sb.setLength(len);
    }
}