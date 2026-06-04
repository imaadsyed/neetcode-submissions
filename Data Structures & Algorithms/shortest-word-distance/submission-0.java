class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        // two pointer
        int l = 0;
        int r = 1;
        int shortestDistance = Integer.MAX_VALUE;
        for (; r < wordsDict.length; r++) {
            if (word1.equals(wordsDict[r])) {
                if (word2.equals(wordsDict[l])) {
                    shortestDistance = Math.min(shortestDistance, r - l);
                }

                // move l to r
                l = r;
            }

            if (word2.equals(wordsDict[r])) {
                if (word1.equals(wordsDict[l])) {
                    shortestDistance = Math.min(shortestDistance, r - l);
                }

                // move l to r
                l = r;
            }
        }

        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }
}
