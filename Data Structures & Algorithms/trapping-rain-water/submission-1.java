class Solution {
    public int trap(int[] height) {
        int l = 0;
        int areaSum = 0;
        for (int r = 1; r < height.length; r++) {
            int curArea = 0;
            while (r < height.length && height[r] < height[l]) {
                curArea += height[l] - height[r];
                r++;
            }
            if (r == height.length) {
                // If we hit the end without finding a taller bar, 
                // reverse the remaining part to handle the decreasing slope.
                int[] reversed = new int[height.length - l];
                for (int i = 0; i < reversed.length; i++) reversed[i] = height[height.length - 1 - i];
                areaSum += trap(reversed);
                break;
            }
            areaSum += curArea;
            l = r;
        }

        return areaSum;
    }
}