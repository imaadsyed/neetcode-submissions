class Solution {
    Map<List<Integer>, List<List<Integer>>> adjList;
    Set<List<Integer>> visited = new HashSet<>();
    public int countPaths(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) {
            return 0;
        }
        createAdjList(grid);
        // System.out.println(adjList.toString());
        
        return getPathCount(Arrays.asList(0, 0), Arrays.asList(grid.length - 1, grid[0].length - 1), visited);
    }

    private int getPathCount(List<Integer> start, List<Integer> end, Set<List<Integer>> visited) {
        if (start.equals(end)) {
            return 1;
        }
        if (visited.contains(start)) {
            return 0;
        }

        visited.add(start);
        int count = 0;
        for (List<Integer> neighbor : adjList.get(start)) {
            count += getPathCount(neighbor, end, visited);
        }
        visited.remove(start);

        return count;
    }

    private void createAdjList(int[][] grid) {
        this.adjList = new HashMap<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) continue;
                List<Integer> key = new ArrayList<>();
                key.add(r);
                key.add(c);
                adjList.put(key, new ArrayList<>());
                // top
                if (r - 1 >= 0 && grid[r-1][c] == 0) {
                    adjList.get(key).add(Arrays.asList(r - 1, c));
                }
                // bottom
                if (r + 1 < grid.length && grid[r+1][c] == 0) {
                    adjList.get(key).add(Arrays.asList(r + 1, c));
                }
                // left
                if (c - 1 >= 0 && grid[r][c-1] == 0) {
                    adjList.get(key).add(Arrays.asList(r, c - 1));
                } 
                // right
                if (c + 1 < grid[0].length && grid[r][c+1] == 0) {
                    adjList.get(key).add(Arrays.asList(r, c + 1));
                }
            }
        }
    }
}