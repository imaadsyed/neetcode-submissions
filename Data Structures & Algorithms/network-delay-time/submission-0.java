class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Create adj list
        Set<Node> unvisited = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        Map<Integer, Node> index = new HashMap<>();
        constructGraph(n, times, unvisited, index);

        // 2. evaluate shortest path
        shortestPath(index.get(k), visited, unvisited);

        // 3. evaluate shortest sum
        if (!unvisited.isEmpty()) {
            return -1;

        }

        int max = 0;
        for (Node node : visited) {
            max = Math.max(max, node.cost);
        }

        return max;
    }

    class Node {
        int id;
        int cost;
        Map<Node, Integer> neighbors;

        Node(int id) {
            this.id = id;
            this.cost = Integer.MAX_VALUE;
            this.neighbors = new HashMap<>();
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public void addNeighbor(Node node, int cost) {
            neighbors.put(node, cost);
        }
    }

    private void shortestPath(Node sourceNode, Set<Node> visited, Set<Node> unvisited) {
        PriorityQueue<Node> heap = new PriorityQueue<>(
            (a, b) -> a.cost - b.cost
        );
        sourceNode.setCost(0);
        heap.offer(sourceNode);

        while(!heap.isEmpty()) {
            Node cur = heap.poll();
            if (visited.contains(cur)) {
                continue;
            }
            visited.add(cur);
            unvisited.remove(cur);

            int curCost = cur.cost;
            for (Node neighbor : cur.neighbors.keySet()) {
                int neighborCost = cur.neighbors.get(neighbor);
                int newCost = curCost + neighborCost;
                if (newCost < neighbor.cost) {
                    neighbor.setCost(newCost);
                }
                heap.offer(neighbor);
            }
        }
    }

    private void constructGraph(int n, int[][] times, Set<Node> unvisited, Map<Integer, Node> index) {
        for (int i = 1; i <= n; i++) {
            if (index.containsKey(i)) {
                continue;
            }
            Node node = new Node(i);
            index.put(i, node);
            unvisited.add(node);
        }

        for (int i = 0; i < times.length; i++) {
            int sourceIndex = times[i][0];
            Node sourceNode = index.get(sourceIndex);
            
            int destIndex = times[i][1];
            Node destNode = index.get(destIndex);

            int cost = times[i][2];;
            sourceNode.addNeighbor(destNode, cost);
        }
    }
}
