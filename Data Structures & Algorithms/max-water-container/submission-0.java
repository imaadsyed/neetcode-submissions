class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            if (heights[l] > heights[r]) {
                maxArea = Math.max(maxArea, (r - l) * heights[r]);
                r--;
            } else {
                maxArea = Math.max(maxArea, (r - l) * heights[l]);
                l++;
            }
        }
        return maxArea;
    }
}
