class Solution {
    private int[] memo = new int[46];

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
}