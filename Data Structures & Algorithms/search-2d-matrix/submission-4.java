class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix[0].length - 1;

        int l = 0;
        int r = matrix.length - 1;
        int row = 0;
        while (l <= r) {
            row = (l + r) / 2;
            if (target < matrix[row][0]) {
                r = row - 1;
            } else if (target > matrix[row][n]) {
                l = row + 1;
            } else {
                // target is in the range of this row
                break;
            }
        } 

        
        l = 0;
        r = matrix[0].length - 1;

        while(l <= r)  {
            int mid = (l + r) / 2;
            if (matrix[row][mid] > target) {
                r = mid - 1;
            } else if (matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;
        // find the column
    }
}
