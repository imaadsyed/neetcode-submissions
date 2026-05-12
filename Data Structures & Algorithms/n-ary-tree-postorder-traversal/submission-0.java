/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> output = new ArrayList<>();

        postOrderTraverse(root, output);

        return output;    
    }

    private void postOrderTraverse(Node node, List<Integer> output) {
        if (node == null) {
            return;
        }

        for (Node child : node.children) {
            postOrderTraverse(child, output);
        }

        output.add(node.val);
    }
}