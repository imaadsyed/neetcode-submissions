class NumArray {
    int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        int prefixRight = prefixSum[right];
        int prefixLeft = left - 1 < 0 ? 0 : prefixSum[left - 1];

        return prefixRight - prefixLeft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */