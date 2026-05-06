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
            while (containsSubstring(s, l, r) && l <= r) {
                String substring = s.substring(l, r + 1);
                if (min == "" || min.length() > substring.length()) {
                    min = substring;
                }
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

    */
    private boolean containsSubstring(String candidate, int start, int end) {
        Map<Character, Integer> goalFreq = new HashMap<>(this.tFreq);
        for (int i = start; i <= end; i++) {
            char ch = candidate.charAt(i);
            if (!goalFreq.containsKey(ch)) {
                continue;
            }
            goalFreq.put(ch, goalFreq.get(ch) - 1);
            if (goalFreq.get(ch) <= 0) {
                goalFreq.remove(ch);
            }
        }

        return goalFreq.size() == 0 ? true : false;
    }
}
