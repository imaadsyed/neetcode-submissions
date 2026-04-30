class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        

        // find the row – 
        // find the first index that is less than equal to 
        int row = 0;
        while(matrix[row][0] <= target) {
            row++;
            if (row == matrix.length) 
                break;
        }
        if (row != 0)
            row--;

        
        int l = 0;
        int r = matrix[0].length - 1;

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
