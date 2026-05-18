class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
        }
        int sumCost = 0;
        for (int i = 0; i < gas.length; i++) {
            sumCost += cost[i];
        }

        if (sumGas < sumCost) {
            return -1;
        }


        int startIndex = 0;
        int gasRemaining = 0;
        for (int i = 0; i < gas.length; i++) {
            gasRemaining += gas[i] - cost[i];

            if (gasRemaining < 0) {
                // we can't start at i or any value in between start and i
                // because gas is a +ve number and even with pre-i supplement, 
                // we can't make it. so update start to i+1
                startIndex = i + 1;
                gasRemaining = 0;
            }
        }

        return startIndex;
    }
}
