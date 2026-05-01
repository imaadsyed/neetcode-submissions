class TreeMap {
    public class Node {
        int key;
        int val;
        Node left;
        Node right;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    // BST
    Node root;

    public TreeMap() {
        this.root = null;
    }

    public void insert(int key, int val) {
        root = insertNode(root, key, val);
        System.out.println("Insert: " + this.toString());
    }

    private Node insertNode(Node node, int key, int val) {
        if (node == null) {
            return new Node(key, val);
        }

        if (key < node.key) {
            node.left = insertNode(node.left, key, val);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key, val);
        } else {
            // case when duplicate
            // System.out.println("duplicate: to insert: " + key + " Existing: " + key);
            node.val = val;
        }

        return node;
    }

    public int get(int key) {
        Node node = getNode(root, key);

        return node == null ? -1 : node.val;
    }
    private Node getNode(Node node, int key) {
        if (node == null) {
            // hit the end – not found
            return null;
        }
        if (node.key == key) {
            return node;
        }

        if (key < node.key) {
            return getNode(node.left, key);
        }
        return getNode(node.right, key);
    }

    public int getMin() {
        if (root == null) {
            return -1;
        }

        Node minNode = getMinNode(root);
        return minNode.val;
    }

    private Node getMinNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMinNode(node.left);
    }

    public int getMax() {
        if (root == null) {
            return -1;
        }

        Node maxNode = getMaxNode(root);
        return maxNode.val;

    }
    private Node getMaxNode(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMaxNode(node.right);
    }

    // TODO: 
    public void remove(int key) {
        root = removeNode(root, key);
    }
    private Node removeNode(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = removeNode(node.left, key);
        } else if (key > node.key) {
            node.right = removeNode(node.right, key);
        } else {
            // case 1: 0 or 1 child
            // return null or other child respectively
            if (node.left == null) { 
                return node.right;
            } 
            if (node.right == null) { 
                return node.left;
            }

            // case 2: 2 children
            // replace with largest leaf in left subtree
            // leaf is guarenteed to hit case 1 (0 children) so no worry about infinite loop
            Node left = node.left;
            while(left.right != null) {
                left = left.right;
            }
            
            node.key = left.key;
            node.val = left.val;
            node.left = removeNode(node.left, left.key);
            return node;
        }

        return node;
    } 

    public List<Integer> getInorderKeys() {
        List<Integer> output = new ArrayList<>();
        getInorderNodes(root, output);
        
        return output;
    }
    private void getInorderNodes(Node node, List<Integer> output) {
        if (node == null) {
            return;
        }
        getInorderNodes(node.left, output);
        output.add(node.key);
        getInorderNodes(node.right, output);
    }

    @Override
    public String toString() {
        return getInorderKeys().toString();
    }
}
