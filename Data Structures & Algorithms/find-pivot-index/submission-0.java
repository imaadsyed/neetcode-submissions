class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }

        int i = 0;
        while (i < nums.length) {
            int leftSum = (i == 0) ? 0 : prefixSum[i - 1];
            int rightSum = prefixSum[nums.length - 1] - prefixSum[i];
            if (leftSum == rightSum) {
                return i;
            }
            i++;
        }

        return -1;
    }
}