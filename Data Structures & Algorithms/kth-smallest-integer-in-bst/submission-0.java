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
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return kthSmallest(root);
    }

    private int kthSmallest(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int val = kthSmallest(root.left);
        if (val != -1) {
            return val;
        }
        
        System.out.println(root.val + ": " + k);
        if (k == 1) {
            return root.val;
        }
        k--;
        return kthSmallest(root.right);
    }
}
