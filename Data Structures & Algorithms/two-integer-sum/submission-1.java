class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
        // construct index map
        // for (int i = 0; i < nums.length; i++) {
        //     // we can assume no duplicates, since exactly one pair.
        // }    

        int[] output = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // for every array element: nums[i], check if target - nums[i] is in index
            if (index.keySet().contains(target-nums[i])) {
                if (i < index.get((target-nums[i]))) {
                    output[0] = i;
                    output[1] = index.get((target-nums[i]));
                } else {
                    output[1] = i;
                    output[0] = index.get((target-nums[i]));
                }
            }
            index.put(nums[i], i);

        }
        return output;    
    }
}
