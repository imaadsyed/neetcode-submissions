class Solution {
    public String longestCommonPrefix(String[] strs) {
        String output = "";
        
        int index = 0;
        while(index < strs[0].length()) {
            char ch = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == 0 || index >= strs[i].length()) {
                    return output;
                }
                if (strs[i].charAt(index) != ch) {
                    return output;
                }
            }
            output += ch;
            index++;
        }

        return output;
    }
}