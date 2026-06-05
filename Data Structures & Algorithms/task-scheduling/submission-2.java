class Solution {
    public int leastInterval(char[] tasks, int n) {
        // map of unique tasks with freq
        // window of size k
        Stack<Character> cpuCycles = new Stack<>();
        Map<Character, Integer> waitPeriod = new HashMap<>();
        List<Character> queue = new ArrayList<>();

        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) counts.put(task, counts.getOrDefault(task, 0) + 1);
        
        List<Character> taskList = new ArrayList<>();
        for (char task : tasks) taskList.add(task);

        while(!taskList.isEmpty()) {
            Character taskToRun = null;
            int bestIdx = -1;
            int maxFreq = -1;
            
            for (int i = 0; i < taskList.size(); i++) {
                char task = taskList.get(i);
                if (!waitPeriod.containsKey(task) || cpuCycles.size() >= waitPeriod.get(task)) {
                    if (counts.get(task) > maxFreq) {
                        maxFreq = counts.get(task);
                        taskToRun = task;
                        bestIdx = i;
                    }
                }
            }
            
            if (taskToRun != null) {
                taskList.remove(bestIdx);
                counts.put(taskToRun, counts.get(taskToRun) - 1);
                cpuCycles.add(taskToRun);
                waitPeriod.put(taskToRun, cpuCycles.size() + n);
            } else {
                cpuCycles.add('-');
            }
        }
        
        return cpuCycles.size();
    }
}