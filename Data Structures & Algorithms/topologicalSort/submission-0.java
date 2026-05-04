class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<Integer> output = new ArrayList<>();
        Map<Integer, Integer> indegrees = new HashMap<>();
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        Queue<Integer> toProcess = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indegrees.put(i, 0);
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            indegrees.put(v, 1 + indegrees.get(v));
            adjacencyList.get(u).add(v);
        }

        for (Integer node : indegrees.keySet()) {
            if (indegrees.get(node) == 0) {
                toProcess.offer(node);
                output.add(node);
            }
        }

        while(!toProcess.isEmpty()) {
            Integer cur = toProcess.poll();
            for (Integer node : adjacencyList.get(cur)) {
                indegrees.put(node, indegrees.get(node) - 1);

                if (indegrees.get(node) == 0) {
                    toProcess.offer(node);
                }
            }
        }

        for (Integer node : indegrees.keySet()) {
            if (indegrees.get(node) != 0) {
                return new ArrayList<>();
            }
        }
        return output;
    }
}
