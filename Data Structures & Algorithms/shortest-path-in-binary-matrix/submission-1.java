class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 1) {
            return -1;
        }

        int pathCount = 0;
        queue.offer(new int[]{0 ,0});

        int[][] neighbors = {
            {-1, -1}, // top left
            {-1, 0}, // top 
            {-1, 1}, // top right 
            {0, -1}, // left
            {0, 1}, // right
            {1, -1}, // bottom left
            {1, 0}, // bottom 
            {1, 1} // bottom right
        };
        while(!queue.isEmpty()) {
            int size = queue.size();
            pathCount++;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1) {
                    return pathCount;
                }
                for (int[] neighbor : neighbors) {
                    int nr = neighbor[0] + cur[0];
                    int nc = neighbor[1] + cur[1];

                    if (nr < 0 || nr >= grid.length) {
                        continue;
                    }
                    if (nc < 0 || nc >= grid[0].length) {
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        continue;
                    }

                    // mark visited
                    grid[nr][nc] = 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}