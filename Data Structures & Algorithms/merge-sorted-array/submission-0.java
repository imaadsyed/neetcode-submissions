class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            int index = findIndex(nums1, nums2[i], nums2.length - i);
            insertAt(nums1, index, nums2[i]);
        }
    }

    public int findIndex(int[] nums, int value, int array2len) {
        int index = 0;
        while (index < nums.length - array2len) {
            if (value < nums[index]) {
                break;
            }

            index++;
        }
        return index;
    }

    public void insertAt(int[] nums, int index, int value) {
        // assume end of array has replacable values.
        // swap right starting from end until index is replacable
        for (int i = nums.length - 1; i > index && i > 0; i--) {
            int tmp = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = tmp;
        }

        nums[index] = value;
    }
}