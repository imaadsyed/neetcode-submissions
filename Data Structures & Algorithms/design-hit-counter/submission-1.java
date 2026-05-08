class HitCounter {

    private Map<Integer, Integer> hitCounter;
    public HitCounter() {
        this.hitCounter = new HashMap<>();
    }
    
    public void hit(int timestamp) {
        if (!hitCounter.containsKey(timestamp)) {
            // record first hit
            hitCounter.put(timestamp, 1); 
        } else {
            hitCounter.put(timestamp, 1 + hitCounter.get(timestamp));
        }

    }
    
    public int getHits(int timestamp) {
        int count = 0;
        for (Integer ts : hitCounter.keySet()) {
            if (ts > timestamp - 300 && ts <= timestamp) {
                count += hitCounter.get(ts);
            }
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
