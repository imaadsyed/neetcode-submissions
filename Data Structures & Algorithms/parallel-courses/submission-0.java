class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> dependents = new HashMap<>();
        Map<Integer, Integer> dependentCount = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            dependents.put(i, new ArrayList<>());
            dependentCount.put(i, 0);
        }

        for (int[] relation : relations) {
            int dependency = relation[0];
            int dependent = relation[1];

            dependents.get(dependent).add(dependency);
            dependentCount.put(dependency, 1 + dependentCount.get(dependency));
        }

        Queue<Integer> canTake = new LinkedList<>();
        for (Integer course : dependentCount.keySet()) {
            if (dependentCount.get(course) == 0) {
                canTake.offer(course);
            }
        }

        int semesterCount = 0;
        while(!canTake.isEmpty()) {
            // when you take a course:
            // remove its dependency from all dependents
            int coursesThisSemester = canTake.size();

            for (int i = 0; i < coursesThisSemester; i++) {
                Integer takeCourse = canTake.poll();
                for(Integer course : dependents.get(takeCourse)) {
                    // reduce dependencyCount – assuming this course was taken 
                    dependentCount.put(course, dependentCount.get(course) - 1);
                    // if no more prereqs, add to next semester batch
                    if (dependentCount.get(course) == 0) {
                        System.out.println("Can now take course: " + course);
                        canTake.offer(course);
                    }
                }
            }

            semesterCount++;
        }   

        for (Integer course : dependentCount.keySet()) {
            if (dependentCount.get(course) != 0) {
                // found a circular dependency involving this course.
                return -1;
            }

        }

        return semesterCount;


    }
}
