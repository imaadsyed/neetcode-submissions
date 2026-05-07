class Solution {
    Map<Character, Integer> tFreq;
    public String minWindow(String s, String t) {
        this.tFreq = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!tFreq.containsKey(ch)) {
                tFreq.put(ch, 1);
                continue;
            }
            tFreq.put(ch, 1 + tFreq.get(ch));
        }
        

        int l = 0;
        String min = "";
        for (int r = 0; r < s.length(); r++) {
            if (tFreq.containsKey(s.charAt(r)))
                tFreq.put(s.charAt(r), tFreq.get(s.charAt(r)) - 1);

            while (containsSubstring() && l <= r) {
                String substring = s.substring(l, r + 1);
                if (min == "" || min.length() > substring.length()) {
                    min = substring;
                }
                if (tFreq.containsKey(s.charAt(l)))
                    tFreq.put(s.charAt(l), 1 + tFreq.get(s.charAt(l)));
                l++;
            }

        }

        return min;
    }

    /*
        s1 contains all characters in s2
        since order is not preserved across strings,
        evaluate once: s2 char frequency 
        copy of s2 char frequency – as we iterate through s1, reduce s2 char frequency
        if copy s2 char frequency is not empty – then false;
        else true;
        O(26)
    */
    private boolean containsSubstring() {
        for (Character ch : tFreq.keySet()) {
            if (tFreq.get(ch) > 0) {
                return false;
            }
        } 

        return true;
    }
}

// Time complexity: O(n^2)
// Space complexity: O(m + n)