class Solution {
    public int reverse(int x) {
        double reverse = 0;
        int negative = 1;
        if (x < 0) {
            negative = -1;
            x = x * negative;
        }

        while(x > 0) {
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            x = x / 10;
        }

        if (reverse > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) reverse * negative;
    }
}
