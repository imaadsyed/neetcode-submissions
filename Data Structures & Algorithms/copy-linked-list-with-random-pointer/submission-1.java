/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> indexOldToNew = new HashMap<>();

        return deepCopy(head, indexOldToNew);
    }

    private Node deepCopy(Node node, Map<Node, Node> index) {
        if (node == null) {
            return null;
        }

        Node newNode = new Node(node.val);
        index.put(node, newNode);

        newNode.next = deepCopy(node.next, index);

        if (node.random != null) {
            if (index.containsKey(node.random)) {
                newNode.random = index.get(node.random);
            } else {
                Node random = new Node(node.random.val);
                index.put(node.random, random);
                // values of the node are added when it's its turn in the stack. 
                newNode.random = random;
            }
        } else {
            newNode.random = null;
        }

        return newNode;
    }
}

// Time Complexity: O() – recursing over the length of the list.
// Space Complexity: O(n) – recursion stack + indexMap
