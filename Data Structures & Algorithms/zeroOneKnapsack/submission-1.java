class Solution {
    Map<String, Integer> maxProfitCache;
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        maxProfitCache = new HashMap<>();
        return getMaxProfit(profit, weight, 0, capacity);
    }

    private int getMaxProfit(List<Integer> profit, List<Integer> weight, int index, int capacity) {
        if (index == profit.size() || capacity <= 0) {
            return 0;
        }
        String key = index + "," + capacity;
        if (maxProfitCache.containsKey(key)) {
            return maxProfitCache.get(key);
        }

        int include = 0;
        // Include index only if weight permits
        if (capacity >= weight.get(index)) {
            include = profit.get(index) + getMaxProfit(profit, weight, index + 1, capacity - weight.get(index));
        }

        // Skip index
        int skip = getMaxProfit(profit, weight, index + 1, capacity);
        int maxProfit = Math.max(include, skip);
        maxProfitCache.put(key, maxProfit);
        return maxProfit;
    }
}