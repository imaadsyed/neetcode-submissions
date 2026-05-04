// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> output = new ArrayList<>();
        if (pairs.size() == 0) {
            return output;
        }
        output.add(new ArrayList<>(pairs));

        for (int i = 1; i < pairs.size(); i++) {
            Pair keyPair = pairs.get(i);
            int j = i - 1;
            while (j >= 0 && pairs.get(j).key > keyPair.key) {
                pairs.set(j + 1, pairs.get(j));
                j--;
            }
            pairs.set(j + 1, keyPair);
            output.add(new ArrayList<>(pairs));
        }


        return output;
    }
}
