class Solution {

    Map<Integer, Node> nodeIndex;

    class Node {
        int id;
        int cost;
        Node prevNode;
        Map<Node, Integer> neighbors;

        Node(int id) {
            this.id = id;
            this.cost = Integer.MAX_VALUE;
            this.prevNode = null;
            this.neighbors = new HashMap<>();
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public void setPrevNode(Node node) {
            this.prevNode = node; 
        }

        public void addNeighbor(Node neighbor, int cost) {
            neighbors.put(neighbor, cost);
        }

    }

    private void construct(int[][] grid, Set<Node> unvisited) {
        // assume grid is n x n
        // for any node i, there are at most 4 neighbors:
        // i - 1, i + 1, i - n, i + n
        // where each of these values is within the bounds of 0, n*n
        // its value in the grid = edge cost
        int n = grid.length;

        for (int i = 0; i < n*n; i++) {
            Node node = new Node(i);
            nodeIndex.put(i, node);
            unvisited.add(node);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = n * i + j;
                Node cur = nodeIndex.get(index);

                // neighbor 1
                if (j - 1 >= 0) {
                    int n1 = index - 1;
                    int cost = grid[i][j-1];

                    Node neighbor = nodeIndex.get(n1);
                    cur.addNeighbor(neighbor, cost);
                }

                // neighbor 2
                if (j + 1 < n) {
                    int n2 = index + 1;
                    int cost = grid[i][j + 1];

                    Node neighbor = nodeIndex.get(n2);
                    cur.addNeighbor(neighbor, cost);
                }

                // neighbor 3
                if (i - 1 >= 0) {
                    int n3 = index - n;
                    int cost = grid[i - 1][j];

                    Node neighbor = nodeIndex.get(n3);
                    cur.addNeighbor(neighbor, cost);
                }

                // neighbor 4
                if (i + 1 < n) {
                    int n4 = index + n;
                    int cost = grid[i + 1][j];

                    Node neighbor = nodeIndex.get(n4);
                    cur.addNeighbor(neighbor, cost);
                }
            }
        }
    }


    private void evalShortPath(Node sourceNode, Set<Node> visited, Set<Node> unvisited) {
        PriorityQueue<Node> heap = new PriorityQueue<>(
            (a, b) -> a.cost - b.cost
        );
        heap.offer(sourceNode);

        while(!heap.isEmpty()) {
            Node cur = heap.poll();
            if (visited.contains(cur)) {
                continue;
            }

            visited.add(cur);
            unvisited.remove(cur);

            for (Node neighbor : cur.neighbors.keySet()) {
                int curCost = cur.cost;
                int neighborCost = cur.neighbors.get(neighbor);
                
                int newCost = Math.max(curCost, neighborCost);
                if (newCost < neighbor.cost) {
                    neighbor.setCost(newCost);
                    neighbor.setPrevNode(cur);
                }
                
                heap.offer(neighbor);
            }
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        // find the path with minimum max value in it and return the max value
        // = find the shortest path from 0,0 to n - 1, n - 1 
        // and return the value of the edge with the highest cost in it 

        // 1. construct graph
        this.nodeIndex = new HashMap<>();
        Set<Node> unvisited = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        construct(grid, unvisited);

        Node sourceNode = nodeIndex.get(0);
        sourceNode.setCost(grid[0][0]);

        evalShortPath(sourceNode, visited, unvisited);
        
        Node destNode = nodeIndex.get(n*n - 1);
        Node node = destNode;
        int max = 0;
        while(node != null) {
            max = Math.max(node.cost, max);
            node = node.prevNode;
        }

        return max;
    }
}
