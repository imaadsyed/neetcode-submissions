class MinStack {
    
    private ArrayList<Integer> stack;
    // keep track of mins
    private ArrayList<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayList<Integer>();
        this.minStack = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        stack.add(val);

        if (minStack.isEmpty()) {
            minStack.add(val);
        } else {
            int currMin = this.minStack.get(this.minStack.size() - 1);
            if (val <= currMin) {
                this.minStack.add(val);
            }
        }
        // System.out.println("push: " + val + ", " + stack.toString() + ", minStack: "  + minStack.toString());
    }
    
    public void pop() {
        // do we need min evaluation?
        if (top() == this.minStack.get(this.minStack.size() - 1)) {
            this.minStack.remove(this.minStack.size() - 1);
        }
        this.stack.remove(this.stack.size() - 1);
        
        // System.out.println("push: " + stack.toString() + ", minStack: "  + minStack.toString());
    }
    
    public int top() {
        return this.stack.get(this.stack.size() - 1);
    }
    
    public int getMin() {
        return this.minStack.get(this.minStack.size() - 1);
    }
}
