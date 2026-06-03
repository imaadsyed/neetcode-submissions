class Solution {
    public boolean isHappy(int n) {
        int temp = n;
        Set<Integer> seen = new HashSet<>();

        while(n != 1) {
            int sum = 0;
            while(n > 0) {
                int d = n % 10;
                n = n / 10;
                sum += d * d;
            }

            if (seen.contains(sum)) {
                return false;
            } else {
                seen.add(sum);
            }

            n = sum;
        }

        return true;
    }
}
