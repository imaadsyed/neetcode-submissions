class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) 
            return false;

        Map<Character, Integer> uniqueCharsS = new HashMap<>();
        Map<Character, Integer> uniqueCharsT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!uniqueCharsS.keySet().contains(s.charAt(i))) {
                uniqueCharsS.put(s.charAt(i), 0);
            }
            if (!uniqueCharsT.keySet().contains(t.charAt(i))) {
                uniqueCharsT.put(t.charAt(i), 0);
            }
            uniqueCharsS.put(s.charAt(i), 1 + uniqueCharsS.get(s.charAt(i)));
            uniqueCharsT.put(t.charAt(i), 1 + uniqueCharsT.get(t.charAt(i)));
        }

        if (uniqueCharsS.keySet().size() != uniqueCharsT.keySet().size()) {
            return false;
        }

        for (Character c : uniqueCharsS.keySet()) {
            if (!uniqueCharsT.keySet().contains(c)) {
                return false;
            }
            if (!uniqueCharsS.get(c).equals(uniqueCharsT.get(c))) {
                return false;
            }
        }

        return true;
    }
}
