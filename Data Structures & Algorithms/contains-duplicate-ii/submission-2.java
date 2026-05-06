class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> unique = new HashSet<>();

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (unique.size() == k + 1) {
                unique.remove(nums[l]);
                l++;
            }

            if (unique.contains(nums[r])) {
                return true;
            }
            unique.add(nums[r]);
        }

        return false;
    }
}