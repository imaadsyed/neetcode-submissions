class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;

        while(l <= r) {
            // ignore non-alphanumeric values
            // Skip non-alphanumeric from left
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            // Skip non-alphanumeric from right
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}

// time complexity: O(n/2) = O(n)
// space complexity: O(1)
