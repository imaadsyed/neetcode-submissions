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
    
    public boolean isBalanced(TreeNode root) {
        return checkHeights(root) != -1;
        
    }

    private int checkHeights(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int lHeight = checkHeights(node.left);
        int rHeight = checkHeights(node.right);

        if (lHeight == -1 || rHeight == -1) {
            return -1;
        }

        if (Math.abs(lHeight - rHeight) > 1) {
            return -1;
        }

        int nodeHeight = 1 + Math.max(lHeight, rHeight);

        System.out.println("lHeight: " + lHeight);
        System.out.println("rHeight: " + rHeight);
        System.out.println("nodeHeight: " + nodeHeight);
        System.out.println();
        return nodeHeight;
    }
}
