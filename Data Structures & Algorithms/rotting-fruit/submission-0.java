class Solution {
    public int orangesRotting(int[][] grid) {
        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dirs = {
            {-1, 0}, // top
            {0, -1}, // left
            {0 , 1}, // right
            {1, 0}   // down
        };
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for(int[] dir : dirs) {
                    int nr = dir[0] + cur[0];
                    int nc = dir[1] + cur[1];

                    if (nr >= 0 && nr < n && nc >=0 && nc < m && !visited[nr][nc] && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        rotted = true;
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            if (rotted) count++;
        }

        if (getFreshCount(grid) != 0) {
            return -1;
        } else {
            return count;
        }
    }

    private int getFreshCount(int[][] grid) {
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[i][c] == 1) {
                    freshCount++;
                }
            }
        }

        return freshCount;
    }
}
