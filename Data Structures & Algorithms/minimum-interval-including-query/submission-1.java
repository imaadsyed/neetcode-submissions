class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // sort by interval size
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));        
        
        int[] output = new int[queries.length];
        int index = 0;
        for (int query : queries) {
            output[index] = -1;
            for (int[] interval : intervals) {
                if (query <= interval[1] && query >= interval[0]) {
                    output[index] = interval[1] - interval[0] + 1;
                    break;
                }
            }
            index++;
        }

        return output;
    }
}
// m queries and n intervals
// time complexity: O(n * m)
// space complexity: O(m)