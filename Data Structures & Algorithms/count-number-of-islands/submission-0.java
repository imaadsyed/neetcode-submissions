class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    // set all neighbors in this island to 0
                    dfs(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (grid[r][c] == '0') {
            return;
        }

        int[][] neighbors = {
            {-1, 0}, // top
            {0, -1}, // left
            {1, 0}, // bottom
            {0, 1}, // right
        };

        // mark visited? 
        grid[r][c] = '0';

        for (int[] neighbor : neighbors) {
            int nr = r + neighbor[0];
            int nc = c + neighbor[1];

            if (nr < 0 || nr >= grid.length) {
                continue;
            }
            if (nc < 0 || nc >= grid[0].length) {
                continue;
            }

            dfs(grid, nr, nc);
        }
    }
}
