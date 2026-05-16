class NumMatrix {
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m + 1][n + 1];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                prefix[row + 1][col + 1] = matrix[row][col] + prefix[row][col + 1] + prefix[row + 1][col] - prefix[row][col];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
    }
}