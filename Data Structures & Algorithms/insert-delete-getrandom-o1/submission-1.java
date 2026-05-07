class RandomizedSet {
    Set<Integer> set;
    Map<Integer, Integer> index;
    Map<Integer, Integer> indexRev;
    public RandomizedSet() {
        this.set = new HashSet<>();
        this.index = new HashMap<>();
        this.indexRev = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        index.put(set.size(), val);
        indexRev.put(val, set.size());
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (set.contains(val)) {

            int i = indexRev.get(val);
            int lastIdx = set.size() - 1;
            int lastVal = index.get(lastIdx);
            
            index.put(i, lastVal);
            indexRev.put(lastVal, i);
            
            set.remove(val);
            indexRev.remove(val);
            index.remove(lastIdx);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int rand = (int) (Math.random() * set.size());
        return index.get(rand);
    }
}
