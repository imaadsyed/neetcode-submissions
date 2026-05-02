class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Map<Integer, Integer> studentPrefCount = new HashMap<>();
        studentPrefCount.put(0, 0);
        studentPrefCount.put(1, 0);

        for (int i = 0; i < students.length; i++) {
            studentPrefCount.put(students[i], 1 + studentPrefCount.get(students[i]));
        } 

        for (int i = 0; i < sandwiches.length; i++) {
            if (studentPrefCount.get(sandwiches[i]) <= 0) {
                break;
            }
            studentPrefCount.put(sandwiches[i], studentPrefCount.get(sandwiches[i]) - 1);
        }
       
        return studentPrefCount.get(0) + studentPrefCount.get(1);
    }
}