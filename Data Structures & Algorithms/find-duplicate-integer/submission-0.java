class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> duplicateTracker = new HashSet<>();

        for (int num : nums) {
            if (duplicateTracker.contains(num)) {
                return num;
            }
            duplicateTracker.add(num);
        }

        // never hit
        return -1;
    }
}
