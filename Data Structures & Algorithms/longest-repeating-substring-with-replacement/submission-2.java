class Solution {
    Map<Character, Integer> freq;
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxFreq = 0;
        freq = new HashMap<>();
        char maxChar = ' ';

        for (int r = 0; r < s.length(); r++) {
            if (!freq.containsKey(s.charAt(r)))     {
                freq.put(s.charAt(r), 0);
            }
            freq.put(s.charAt(r), 1 + freq.get(s.charAt(r)));
            if (maxChar == ' ') {
                maxChar = s.charAt(r);
            }
            if (freq.get(maxChar) < freq.get(s.charAt(r))) {
                maxChar = s.charAt(r);
            }

            // condition to slide
            if ((r - l + 1) - freq.get(maxChar) > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
                // Recalculate maxChar frequency within current window
                for (char c : freq.keySet()) {
                    if (freq.get(c) > freq.get(maxChar)) maxChar = c;
                }
            }

            maxFreq = Math.max(maxFreq, r - l + 1);
        }

        return maxFreq;
    }
}