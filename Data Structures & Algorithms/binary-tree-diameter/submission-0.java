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
    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        dfs(root);

        return result;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int heightLeft = dfs(root.left);
        int heightRight = dfs(root.right);
        int diameter = heightLeft + heightRight;
        result = Math.max(result, diameter);

        return 1 + Math.max(heightLeft, heightRight);
    }
}
