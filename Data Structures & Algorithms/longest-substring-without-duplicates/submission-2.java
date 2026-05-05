class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        Set<Character> unique = new HashSet<>();
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!unique.contains(s.charAt(i))) {
                unique.add(s.charAt(i));
                r++;
                maxLength = Math.max(maxLength, r - l);
            } else {
                while(unique.contains(s.charAt(i)) && l < r) {
                    unique.remove(s.charAt(l));
                    l++;
                }
                unique.add(s.charAt(i));
                r++;
                maxLength = Math.max(maxLength, r - l);
            }
        }

        return maxLength;
    }
}
