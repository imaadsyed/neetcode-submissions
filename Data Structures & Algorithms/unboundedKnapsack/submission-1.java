class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] memo = new int[profit.size()][capacity + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return getMaxProfit(profit, weight, capacity, 0, memo);
    }

    private int getMaxProfit(List<Integer> profit, List<Integer> weight, int capacity, int index, int[][] memo) {
        if (index == profit.size() || capacity <= 0) {
            return 0;
        }
        if (memo[index][capacity] != -1) return memo[index][capacity];

        // Option 1: Skip the current item
        int res = getMaxProfit(profit, weight, capacity, index + 1, memo);

        // Option 2: Take the current item (if it fits) and stay at the same index
        if (capacity >= weight.get(index)) {
            res = Math.max(res, profit.get(index) + getMaxProfit(profit, weight, capacity - weight.get(index), index, memo));
        }
        
        return memo[index][capacity] = res;
    }
}