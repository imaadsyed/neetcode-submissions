class Solution {
    public int[] sortArray(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private int[] sort(int[] nums, int start, int end) {
        if (start >= end) {
            int[] output = new int[1];
            output[0] = nums[end];
            return output;
        }
        int mid = (start + end) / 2;
        int[] left = sort(nums, start, mid);
        int[] right = sort(nums, mid + 1, end);

        return merge(left, right);
    }

    private int[] merge(int[] one, int[] two) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[one.length + two.length];
        while (i < one.length || j < two.length) {
            if (i == one.length) {
                merged[k++] = two[j++]; 
            } else if (j == two.length) {
                merged[k++] = one[i++];
            } else if (one[i] < two[j]) {
                merged[k++] = one[i++];
            } else {
                merged[k++] = two[j++];   
            }
        }

        return merged;
    }
}