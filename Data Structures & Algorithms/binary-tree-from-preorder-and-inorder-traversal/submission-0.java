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

 /**
       1
      / \
    2    4
        / \
       3   5

Preorder [1, 2, 4, 3, 5]
InOrder [2, 1, 3, 4, 5]
========================
       1
      / \
    2    4
   /    / \
  6    3   5

Preorder [1, 2, 6, 4, 3, 5]
InOrder [6, 2, 1, 3, 4, 5]
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            // throw exception
            // also if elements don't match
            return null;
        }
        int nodeCount = inorder.length;
        Map<Integer, Integer> index = new HashMap<>();
        
        // find root –> what index has the same values after it
        TreeNode root = new TreeNode(preorder[0]);
        int rootInOrderIndex;

        for (int i = 0; i < nodeCount; i++) {
            if (inorder[i] == root.val) {
                rootInOrderIndex = inorder[i];
            }
            index.put(inorder[i], i);
        }

        TreeNode cur;
        int curInOrderIndex;
        for (int i = 1; i < nodeCount; i++) {

            insert(inorder, index, root, preorder[i]);

        }

        return root;
    }

    private TreeNode insert(int[] inorder, Map<Integer, Integer> index, TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (index.get(val) < index.get(root.val)) {
            root.left = insert(inorder, index, root.left, val);
        } else {
            root.right = insert(inorder, index, root.right, val);
        }
        return root;
    }
}
