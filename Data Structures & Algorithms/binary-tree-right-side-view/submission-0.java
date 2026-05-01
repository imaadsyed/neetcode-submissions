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
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> output = new ArrayList<>();

        q.add(root);
        while(!q.isEmpty()) {
            // for each level of the tree, add the last (right-most) value

            // qSize ensures that we only process those values in the q intended for this iteration
            // excluding any new ones added during the iteration. 
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();
                if (node == null) {
                    continue;
                }

                if (i == qSize - 1) {
                    output.add(node.val);    
                }

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return output;
    }
}
