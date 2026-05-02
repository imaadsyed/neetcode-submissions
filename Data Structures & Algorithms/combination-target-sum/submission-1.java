class Solution {
    List<List<Integer>> paths;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        sort(nums);
        backtrack(nums, 0, path, 0, target);

        return paths;
    }

    private void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];

            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums [j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    private void backtrack(int[] nums, int i, 
                                    List<Integer> path, int pathSum, int target) {
        if (i == nums.length || pathSum + nums[i] > target) {
            return;
        }
        if (pathSum + nums[i] <= target) {
            path.add(nums[i]);
            pathSum += nums[i];
            if (pathSum == target) {
                paths.add(new ArrayList<>(path));
            }
        }
        
        
        // keep going with same until we hit pathSum > target
        backtrack(nums, i, path, pathSum, target);
        // backtrack
        path.remove(path.size() - 1);
        pathSum -= nums[i];
        // move on
        backtrack(nums, i + 1, path, pathSum, target);
    }
}
