class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // hierarchy – modeled via tree? graph? 
        // failure case – cycle – trees cannot have cycle – graph

        // adjList – models the graph
        Map<Integer, Set<Integer>> dependencies = new HashMap<>();
        // models the dependencies
        Map<Integer, Integer> indegrees = new HashMap<>();
        for (int i = 0; i < numCourses; i ++) {
            indegrees.put(i, 0);
            dependencies.put(i, new HashSet<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int prereq = prerequisites[i][1];
            int cur = prerequisites[i][0];

            indegrees.put(cur, indegrees.get(cur) + 1);
            dependencies.get(prereq).add(cur);
        }

        Queue<Integer> toTake = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees.get(i) == 0) {
                // if no dependencies, we can take the course
                toTake.add(i);
            }
        }

        while(!toTake.isEmpty()) {
            int take = toTake.poll();
            for (Integer dependent : dependencies.get(take)) {
                indegrees.put(dependent, indegrees.get(dependent) - 1);   
                if (indegrees.get(dependent) == 0) {
                    toTake.add(dependent);
                }
            }
        }

        for (Integer course : indegrees.keySet()) {
            if (indegrees.get(course) != 0) {
                return false;
            }
        }

        return true;
    }
}


// time complexity: O(N + E)
// space complexity: O(N + E)