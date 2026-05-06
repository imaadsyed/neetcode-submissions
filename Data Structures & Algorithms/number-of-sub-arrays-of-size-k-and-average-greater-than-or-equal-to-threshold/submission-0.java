class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        Queue<Integer> window = new LinkedList<>();
        int count = 0;
        int l = 0;
        int windowSum = 0;
        for (int r = 0; r < arr.length; r++) {
            windowSum += arr[r];
            window.offer(arr[r]);

            if (window.size() == k) {
                if (windowSum / k >= threshold) {
                    count++;
                }
                // System.out.println(window + " avg: " + windowSum/k + " count: " + count);
                // pop from queue – increase window size
                windowSum -= window.poll();
                l++;
            }
        }    
        return count;
    }
}