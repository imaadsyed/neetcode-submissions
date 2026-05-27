class RandomizedSet {
    Set<Integer> set;
    List<Integer> values;
    Map<Integer, Integer> index;

    public RandomizedSet() {
        this.set = new HashSet<>();
        this.values = new ArrayList<>();
        this.index = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }

        set.add(val);
        values.add(val);
        index.put(val, values.size() - 1);
        
        return true;
    }
    
    public boolean remove(int val) {
        if (!set.contains(val)) {
            return false;
        }
        
        int valIndex = index.get(val);
        int lastIndex = values.size() - 1;
        int lastValue = values.get(lastIndex);

        set.remove(val);
        index.remove(val);

        values.set(valIndex, lastValue);
        values.remove(lastIndex);
        index.put(lastValue, valIndex);
        return true;
    }
    
    public int getRandom() {
        int random = (int) Math.random() * set.size();

        return values.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */