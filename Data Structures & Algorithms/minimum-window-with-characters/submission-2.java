class Solution {
    public String minWindow(String s, String t) {
        String output = "";
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tCount = new HashMap<>();
        // for t - get character count
        // output must be at least of length t
        // once a substring is found, don't abandon history
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!tCount.containsKey(ch)) {
                tCount.put(ch, 0);
            }

            tCount.put(ch, 1 + tCount.get(ch));
        }

        int l = 0;
        int charMet = 0;
        for (int r = 0; r < s.length(); r++) {
            // variable size sliding window
            // keep moving right pointer until condition is satisfied
            // when condition is satisifed, 
            // move left pointer until we hit 
            // the first character that also exists in t
            // then check if r - l + 1 < output.length()
            // if yes, output = substring(l, r)
            // if no, continue

            char ch = s.charAt(r);
            if (tCount.containsKey(ch)) {
                // decrement count by 1
                tCount.put(ch, tCount.get(ch) - 1);
                if (tCount.get(ch) == 0) {
                    charMet++;
                }
            }

            // conditionMet
            while (charMet == tCount.size()) {
                int substrLength = r - l + 1;
                if (output.equals("") || substrLength < output.length()) {
                    output = s.substring(l, r + 1);
                }
                
                char leftChar = s.charAt(l);
                if (tCount.containsKey(leftChar)) {
                    if (tCount.get(leftChar) == 0) {
                        charMet--;
                    }
                    tCount.put(leftChar, tCount.get(leftChar) + 1);
                }
                l++;
            }

        }

        return output;
    }
}