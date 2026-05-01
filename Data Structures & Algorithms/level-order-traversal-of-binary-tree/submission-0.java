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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        q.add(root);

        TreeNode node = root;
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int qSize = q.size();
            for (int i= 0; i < qSize; i++) {
                node = q.poll();
                if (node == null) {
                    continue;
                }
                q.add(node.left);
                q.add(node.right);
                level.add(node.val);
            }

            if (level.size() > 0) {
                output.add(level);
            }
        }
        
        return output;
    }
}
