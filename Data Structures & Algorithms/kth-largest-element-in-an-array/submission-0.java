class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> b - a
        );

        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            heap.poll();
        }

        return heap.poll();
    }
}
