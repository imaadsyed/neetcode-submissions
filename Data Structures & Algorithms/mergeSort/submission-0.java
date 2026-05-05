// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs.isEmpty()) return new ArrayList<>();
        return mergeSort(pairs, 0, pairs.size() - 1);
    }
    public List<Pair> mergeSort(List<Pair> pairs, int start, int end) {
        if (start == end) {
            List<Pair> output = new ArrayList<Pair>();
            output.add(pairs.get(start));
            return output;
        }
        int mid = (start + end) / 2;
        List<Pair> left = mergeSort(pairs, start, mid);
        List<Pair> right = mergeSort(pairs, mid + 1, end);

        return merge(left, right);
    }

    private List<Pair> merge(List<Pair> one, List<Pair> two) {
        List<Pair> merged = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < one.size() || j < two.size()) {
            if (i == one.size()) {
                merged.add(two.get(j));
                j++;
            } else if (j == two.size()) {
                merged.add(one.get(i));
                i++;
            } else {
                if (one.get(i).key <= two.get(j).key) {
                    merged.add(one.get(i));
                    i++;
                } else {
                    merged.add(two.get(j));
                    j++;    
                }
            }
        }
        return merged;
    }
}
