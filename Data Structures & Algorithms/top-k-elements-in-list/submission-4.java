class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        for (int num : nums) {
            if (!freq.containsKey(num)) {
                freq.put(num, 1);
                continue;
            }
            freq.put(num, 1 + freq.get(num));
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            maxHeap.offer(entry);
        }

        int[] output = new int[k];
        k--;
        while(k >= 0) {
            output[k--] = maxHeap.poll().getKey();
        }

        return output;
    }
}
