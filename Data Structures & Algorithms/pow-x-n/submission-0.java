class Solution {
    public double myPow(double x, int n) {
        double output = 1;

        if (n < 0) {
            n *= -1;
            for (int i = 0; i < n; i++) {
                output /= x;
            }
        } else if (n == 0) {
            return output;
        } else {
            for (int i = 0; i < n; i++) {
                output *= x;
            }
        }

        

        return output;
    }
}
