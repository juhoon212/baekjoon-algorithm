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
        // 트리의 노드 중 해당하는 노드의 val값이 맞으면 그 노드를 지운다.
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // 노드의 val가 키랑 값이 같을때
            // 1.자식이 없을 때(리프노드)
            if (root.left == null && root.right == null) {
                // 그 노드를 지운다.
                return null;
            }
            // 2. 자식이 하나만 있을 때
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // 3. 자식이 둘다있을 때
            // 그러면 지운노드가 맞을 때 그 노드의 자식 노드 중 오른쪽의 것들 중 가장 작은노드를
            if (root.left != null && root.right != null) {
                // root의 right 중 가장 작은 노드를 찾는다.
                TreeNode result = findNode(root.right);
                // 지운 노드로 끌어올려 노드의 지워진 부분을 메꾼다.
                root.val = result.val;
                // root 오른쪽 하위노드를 지운다.
                root.right = deleteNode(root.right, result.val);
            }
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