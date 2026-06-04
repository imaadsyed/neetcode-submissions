class Solution {
    /**
    Valid tree:
    - n-1 edges
    - fully connected

    Do a BFS and ensure we are able to visit all nodes.
    */
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        if (n == 1) return true;

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int d = edges[i][1];

            adjList.computeIfAbsent(s, k -> new ArrayList<>()).add(d);
            adjList.computeIfAbsent(d, k -> new ArrayList<>()).add(s);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited.add(0);

        while(!q.isEmpty()) {
            int cur = q.poll();
            if (adjList.containsKey(cur)) {
                for (Integer neighbor : adjList.get(cur)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
        }

        return visited.size() == n;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
}