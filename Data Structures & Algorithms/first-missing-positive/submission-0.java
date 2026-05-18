class Solution {
    public int firstMissingPositive(int[] nums) {
        int smallestPositive = 1;
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }

            if (nums[i] == smallestPositive) {
                smallestPositive++;
                while (seen.contains(smallestPositive)) {
                    smallestPositive++;
                }                
            }
            seen.add(nums[i]);
        }

        return smallestPositive;
    }
}