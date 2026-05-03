class Solution {
    public int largestRectangleArea(int[] heights) {
        List<List<Integer>> columns = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            List<Integer> consecutives = new ArrayList<>();
            consecutives.add(heights[i]);
            int j = i + 1;
            
            while(j < heights.length && heights[j] >= heights[i]) {
                consecutives.add(heights[i]);
                j++;
            }
            j = i - 1;
            
            while(j >=0 && heights[j] >= heights[i]) {
                // System.out.println("DEBUG: Going left i: " + i + ", j: " + j);
                consecutives.add(heights[i]);
                j--;
            }
            // System.out.println(i + " " + j);
            // i = j - 1;
            columns.add(consecutives);
        }

        int maxArea = 0;
        for (List<Integer> consecColumns : columns) {
            
            int area = consecColumns.size() * consecColumns.get(0);
            // System.out.println(consecColumns.toString() + " area: " + area);
            if (area > maxArea) {
                maxArea = area;
            }
        }

        
        return maxArea;
    }
}
