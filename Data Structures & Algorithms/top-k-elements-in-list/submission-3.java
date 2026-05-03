class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // get frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();
        // construct a heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(freq.get(a), freq.get(b))
        );
        for (int i = 0; i < nums.length; i++) {
            if (!freq.keySet().contains(nums[i])) {
                freq.put(nums[i], 0);
            }
            freq.put(nums[i], 1 + freq.get(nums[i]));
        }

        for (Integer key : freq.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = minHeap.poll();
        }


        return output;
    }
}