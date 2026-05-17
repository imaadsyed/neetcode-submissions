class WordDictionary {
    class Node {
        Boolean isWordEnd;
        HashMap<Character, Node> children;

        Node() {
            children = new HashMap<>();
            isWordEnd = false;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node());
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public void markWordEnd() {
            this.isWordEnd = true;
        }

        public boolean isWordEnd() {
            return this.isWordEnd;
        }
    }

    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.hasChild(ch)) {
                cur.addChild(ch);
            }
            cur = cur.getChild(ch);
        }
        cur.markWordEnd();
    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, Node node) {
        if (index == word.length()) {
            return node.isWordEnd();
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            for (Node child : node.children.values()) {
                if (searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
        } else {
            if (node.hasChild(ch)) {
                return searchInNode(word, index + 1, node.getChild(ch));
            }
        }
        return false;
    }
}