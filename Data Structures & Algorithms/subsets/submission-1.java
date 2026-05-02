class Solution {
    List<List<Integer>> subsets;

    public List<List<Integer>> subsets(int[] nums) {
        subsets = new ArrayList<>();
        // every input has at least 1 subset = empty list
        backtrack(nums, new ArrayList<>(), 0);

        return subsets;
    }

    private void backtrack(int[] nums, List<Integer> subset, int i) {
        if (i == nums.length) {
            // we've reached leaf level 
            subsets.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[i]);
        backtrack(nums, subset, i + 1);

        subset.remove(subset.size() - 1);
        backtrack(nums, subset, i + 1);
    }
}