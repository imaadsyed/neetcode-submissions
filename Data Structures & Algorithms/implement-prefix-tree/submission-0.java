class PrefixTree {
    class TreeNode {
        Map<Character, TreeNode> children;
        Boolean isWord;

        TreeNode() {
            children = new HashMap<>();
            isWord = false;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void recordChild(char ch) {
            children.put(ch, new TreeNode());
        }

        public TreeNode getChild(char ch) {
            // todo validate contains
            return children.get(ch);
        }
    }
    
    TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (!cur.hasChild(ch)) {
                cur.recordChild(ch);
            }
            cur = cur.getChild(ch);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (!cur.hasChild(ch)) {
                return false;
            }
            cur = cur.getChild(ch);
        }
        return cur.isWord == true;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            
            if (!cur.hasChild(ch)) {
                return false;
            }
            cur = cur.getChild(ch);
        }

        return true;
    }
}
