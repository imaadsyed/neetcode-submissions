class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int output = -1;

        // iterate through gas stations and see if 
        // gas[i] - cost[i] >= 0 for all combinations of i

        // brute force = O(n^2)
        for (int i = 0; i < gas.length; i++) {
            int curGas = gas[i] - cost[i];
            if (curGas < 0) {
                continue;
            }

            int j = i + 1;
            // simulate loop traversal. 
            while(j != i) {
                System.out.println(j);
                if (j == gas.length) {
                    
                    // reset – modulate
                    j = 0;
                    continue;
                }

                curGas += gas[j];
                curGas -= cost[j];
                if (curGas < 0) {
                    break;
                }
                j++;
            }

            if (j == i) {
                output = i;
                break;
            }
        }

        return output;
    }
}
