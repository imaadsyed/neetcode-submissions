class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        // construct adjList. edges flow from previous to next
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> prereqCount = new HashMap<>();

        // initialize
        for (int i = 1; i <=n; i++) {
            adjList.put(i, new ArrayList<>());
            prereqCount.put(i, 0);
        }

        // hydrate
        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];

            prereqCount.put(next, prereqCount.get(next) + 1);
            adjList.get(prev).add(next);
        }

        Queue<Integer> coursesCanTake = new LinkedList<>();
        // what courses can be taken in first sem
        for (Map.Entry<Integer, Integer> prereq : prereqCount.entrySet()) {
            if (prereq.getValue() == 0) {
                coursesCanTake.offer(prereq.getKey());
            }
        }


        int semCount = 0;
        // take all course you can.

        while(!coursesCanTake.isEmpty()) {
            semCount++;
            int coursesThisSem = coursesCanTake.size();

            for (int i = 0; i < coursesThisSem; i++) {
                int take = coursesCanTake.poll();

                // take course = remove dependency from all its children
                for (Integer next : adjList.get(take)) {
                    prereqCount.put(next, prereqCount.get(next) - 1);

                    // if next has 0 prereqs after taking this course = it can be taken next sem 
                    if (prereqCount.get(next) == 0) {
                        coursesCanTake.offer(next);
                    }
                }
            }
        }

        // check if can't take 
        for (Map.Entry<Integer, Integer> prereq : prereqCount.entrySet()) {
            if (prereq.getValue() != 0) {
                return -1;
            }
        }

        return semCount;
    }
}
